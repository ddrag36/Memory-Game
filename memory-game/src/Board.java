import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
/**
 * This class contains the logic of modes: solo normal,solo duo
 */
public class Board extends JFrame{


    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
    private int score=0;

    /**
     * @param pairs card pairs
     * @param rows rows of array
     * @param columns clomumns of array
     *  in this method tables are created and numbers are passed. A timer is created for the cards to return after a delay.
     */
public Board(int pairs,int rows,int columns){


        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
       Collections.shuffle(cardVals);

        for (int val : cardVals){
            Card c = new Card();
            c.setId(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        //set up the timer
        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows , columns));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getId()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getId()));
            t.start();

        }
    }

    /**
      * In this method, the two cards are checked and the user's efforts are counted. If the two cards are the same then he can not tread on them again otherwise they turn and the user continues his efforts.
      * When he finds all the cards the game ends and two windows appear in which it is stated that the user won and how many attempts he made to complete the game
     */

    public void checkCards(){

        if (c1.getId() == c2.getId()){
            c1.setEnabled(false);
            c2.setEnabled(false);
            c1.setMatched(true);
            c2.setMatched(true);
            score=score+1;
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                JOptionPane.showMessageDialog(null, "Your score : " + score);
                System.exit(0);
            }
        }

        else{
            c1.setText("");
            c2.setText("");
            score=score+1;
        }
        c1 = null;
        c2 = null;
    }

    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }

}

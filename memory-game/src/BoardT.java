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
 * Same logic with Board but for modes: solo, trio.
 */
public class BoardT extends JFrame{


    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Card c3;
    private Timer t;
    private int score=0;

    public BoardT(int pairs,int rows,int columns){


        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
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
        if (c1 == null && c2 == null && c3==null){
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getId()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getId()));

        }
        if (c2!=null && c2!=selectedCard && c3==null){
            c3=selectedCard;
            c3.setText(String.valueOf(c3.getId()));
            t.start();
        }
    }

    public void checkCards(){
        if (c1.getId() == c2.getId() && c1.getId()==c3.getId()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c3.setEnabled(false);
            c1.setMatched(true); //flags the button as having been matched
            c2.setMatched(true);
            c3.setMatched(true);
            score=score+1;
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                JOptionPane.showMessageDialog(null, "Your score : " + score);
                System.exit(0);
            }
        }

        else{
            c1.setText(""); //'hides' text
            c2.setText("");
            c3.setText("");
            score=score+1;
        }
        c1 = null; //reset c1 and c2
        c2 = null;
        c3 = null;
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

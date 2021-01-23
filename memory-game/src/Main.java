

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The game starts opening a panel where the user chooses the preferred mode (normal,duo,trio). Depending on the user's click,
 * the corresponding class is executed.
 *
 */s

public class Main {

    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Memory game");
        JPanel panel=new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.yellow);
        JLabel label=new JLabel("Choose categorie: ");
        JButton button1=new JButton();
        JButton button2=new JButton();
        JButton button3=new JButton();
        JButton button4=new JButton();
        button1.setText("Solo Normal");
        button2.setText("Solo Duo");
        button3.setText("Solo Trio");
        button4.setText("Monomaxia");
        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board b = new Board(12,4,6);
                b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
                b.setLocation(500, 250);
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.pack();
                b.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board b = new Board(24,6,8);
                b.setPreferredSize(new Dimension(501,500)); //need to use this instead of setSize
                b.setLocation(500, 250);
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.pack();
                b.setVisible(true);

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardT b = new BoardT(12,6,6);
                b.setPreferredSize(new Dimension(502,500)); //need to use this instead of setSize
                b.setLocation(500, 250);
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.pack();
                b.setVisible(true);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board b = new Board(12,6,4);
                b.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
                b.setLocation(500, 250);
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.pack();
                b.setVisible(true);
                Board c = new Board(12,6,4);
                c.setPreferredSize(new Dimension(500,500)); //need to use this instead of setSize
                c.setLocation(500, 250);
                c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                c.pack();
                c.setVisible(true);

            }
        });


    }
}


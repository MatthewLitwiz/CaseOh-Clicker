package Layouts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utilities.ImageClicker;
import Utilities.LabelClickable;

public class MainLayout extends JPanel implements ActionListener{

    ImageClicker imageClicker = new ImageClicker();
    LabelClickable labelClickable = new LabelClickable();

    private int count = 100;

    private boolean x2ClicksActive = false;

    JLabel counterLabel;

    public MainLayout() {
        setLayout(null);

        counterLabel = new JLabel();
        counterLabel.setBounds(200, 0, 200, 50);
        counterLabel.setText("Count: " + count);
        counterLabel.setFont(counterLabel.getFont().deriveFont(20.0f));

        // MAIN counting logic
        imageClicker.ClickableImage("src/Images/CaseOhFace.jpg", 200, 400, 0, 0, () -> {
            if (x2ClicksActive) {
                count += 2;
            } else {
                count += 1;
            }

            counterLabel.setText("Count: " + count);
        });
        

        // shop system 

        JLabel shopLabel = new JLabel();
        shopLabel.setBounds(400, 0, 400, 50);
        shopLabel.setText("Shop:");
        shopLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        shopLabel.setForeground(Color.BLUE);

        // buy x2 clicks

        JLabel x2Clicks = new JLabel(); 
        x2Clicks.setBounds(400, 50, 400, 50);
        x2Clicks.setText("Buy x2 Clicks - 100 clicks");
        x2Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x2Clicks.setForeground(Color.BLACK);

        LabelClickable.makeLabelClickable(x2Clicks, () -> {
            if (count >= 100 && !x2ClicksActive) {
                count -= 100;

                x2ClicksActive = true;

                counterLabel.setText("Count: " + count);
                JOptionPane.showMessageDialog(null, "You bought x2 clicks!");

                x2Clicks.setText("x2 Clicks Active");
                x2Clicks.setForeground(Color.GREEN);
            } else if (x2ClicksActive) {
                JOptionPane.showMessageDialog(null, "You already have x2 clicks active!");
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });

        add(x2Clicks);
        add(shopLabel);
        add(imageClicker);
        add(counterLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // add listener for x2 clicks

        String key = e.getActionCommand();

    }

}
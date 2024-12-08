package Layouts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Font;

import Utilities.ImageClicker;
import Utilities.LabelClickable;

public class MainLayout extends JPanel{

    ImageClicker imageClicker = new ImageClicker();
    LabelClickable labelClickable = new LabelClickable();

    private JTabbedPane Shoptabs;

    private int count = 100;

    private boolean x2ClicksActive = false;

    JPanel upgrades, currentPerks,idleMiner;
    JLabel counterLabel, shopLabel, x2Clicks;

    public MainLayout() {
        setLayout(null);

        Shoptabs = new JTabbedPane();
        Shoptabs.setBounds(250, 60, 900, 400);

        // tabs
        upgrades = new JPanel();
        upgrades.setLayout(new javax.swing.BoxLayout(upgrades, javax.swing.BoxLayout.Y_AXIS));

        Shoptabs.addTab("Upgrade", upgrades);

        currentPerks = new JPanel();
        currentPerks.setLayout(new javax.swing.BoxLayout(currentPerks, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Perks", currentPerks);

        idleMiner = new JPanel();
        idleMiner.setLayout(new javax.swing.BoxLayout(idleMiner, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Idle Miner", idleMiner);


        counterLabel = new JLabel();
        counterLabel.setBounds(0, 400, 200, 50);
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
        

        // shop 

        shopLabel = new JLabel();
        shopLabel.setBounds(250, 0, 400, 50);
        shopLabel.setText("Shop:");
        shopLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        shopLabel.setForeground(Color.BLUE);

        // buy x2 clicks

        x2Clicks = new JLabel(); 
        x2Clicks.setText("Buy x2 Clicks - 100 clicks");
        x2Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x2Clicks.setForeground(Color.BLACK);

        LabelClickable.makeLabelClickable(x2Clicks, () -> {
            if (count >= 100 && !x2ClicksActive) {

                if(x2ClicksActive) {
                    JOptionPane.showMessageDialog(null, "You already have x2 clicks active!");
                }


                count -= 100;
                x2ClicksActive = true;
        
                // Add x2Clicks to currentPerks
                upgrades.remove(x2Clicks);
                JLabel x2ClicksActive = new JLabel();
                x2ClicksActive.setText("x2Clicks ACTIVE");
                x2ClicksActive.setFont(new Font("Arial", Font.BOLD, 15));
                x2ClicksActive.setForeground(Color.GREEN);

                upgrades.revalidate();
                upgrades.repaint();
                currentPerks.add(x2ClicksActive);
                currentPerks.revalidate();
                currentPerks.repaint();
        
                counterLabel.setText("Count: " + count);
                JOptionPane.showMessageDialog(null, "You bought x2 clicks!");
        
                // Strike-through text
                x2Clicks.setText("<html><s>Buy x2 Clicks - 100 clicks</s></html>");
            } else if (x2ClicksActive) {
                JOptionPane.showMessageDialog(null, "You already have x2 clicks active!");
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });

        add(Shoptabs);
        upgrades.add(x2Clicks);
        add(shopLabel);
        add(imageClicker);
        add(counterLabel);

    }

}
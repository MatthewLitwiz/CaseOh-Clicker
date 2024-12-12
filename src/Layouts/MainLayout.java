package Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Utilities.ImageClicker;
import Utilities.LabelClickable;

public class MainLayout extends JPanel {

    ImageClicker imageClicker = new ImageClicker();
    LabelClickable labelClickable = new LabelClickable();

    private JTabbedPane Shoptabs;

    private int count = 8000;
    private double temp = 0.0;

    private boolean x2ClicksActive = false;
    private boolean x3ClicksActive = false;

    private int ClicksPurchased = 0; // Number of Clicks Items purchased
    private int BurgerPurchased = 0; // Number of Burgers purchased
    private double cps = 0; // tracks clicks per second

    JPanel upgrades, currentPerks, items;
    JLabel counterLabel, Bakery, x2Clicks, x3Clicks, clicksItemLabel, burgerItemLabel, cpsLabel;

    public MainLayout() {
        setLayout(null);

        Shoptabs = new JTabbedPane();
        Shoptabs.setBounds(1300, 100, 600, 900);

        // tabs
        items = new JPanel();
        items.setLayout(new javax.swing.BoxLayout(items, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Items", items);

        upgrades = new JPanel();
        upgrades.setLayout(new javax.swing.BoxLayout(upgrades, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Upgrade", upgrades);

        currentPerks = new JPanel();
        currentPerks.setLayout(new javax.swing.BoxLayout(currentPerks, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Perks", currentPerks);

        counterLabel = new JLabel();
        counterLabel.setBounds(200, 100, 200, 50);
        counterLabel.setText("Count: " + count);
        counterLabel.setFont(counterLabel.getFont().deriveFont(20.0f));

        // MAIN counting logic
        imageClicker.ClickableImage("src/Images/CaseOhFace.jpg", 450, 700, 50, 200, () -> {
            if (x3ClicksActive && x2ClicksActive) {
                count += 3; // x3Clicks overrides x2Clicks
            } else if (x2ClicksActive) {
                count += 2; // Only x2Clicks is active
            } else {
                count++; // No boosts active
            }

            counterLabel.setText("Count: " + count);
        });

        // set upgrades to empty if empty
        if (upgrades.getComponentCount() == 0) {
            upgrades.add(new JLabel("No upgrades available"));
        }

        // shop Name

        Bakery = new JLabel();
        Bakery.setBounds(150, 50, 400, 50);
        Bakery.setText("Your Bakery");
        Bakery.setFont(new Font("Tahoma", Font.BOLD, 40));
        Bakery.setForeground(Color.BLUE);

        // buy x2 clicks

        x2Clicks = new JLabel();
        x2Clicks.setText("Buy x2 Clicks - 100 clicks");
        x2Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x2Clicks.setForeground(Color.BLACK);

        // buy x3 clicks
        x3Clicks = new JLabel();
        x3Clicks.setText("Buy x3 Clicks - 1200 clicks");
        x3Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x3Clicks.setForeground(Color.BLACK);

        clicksItemLabel = new JLabel();
        clicksItemLabel.setText("Buy Clicks Item (0.1 cps) - 100 clicks");
        clicksItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clicksItemLabel.setForeground(Color.BLACK);

        LabelClickable.makeLabelClickable(clicksItemLabel, () -> {
            if (count >= 100) {
                count -= 100;
                ClicksPurchased++;
                cps += 0.1;
                counterLabel.setText("Count: " + count);
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                clicksItemLabel.setText("Buy Clicks Item (0.1 cps) - 100 clicks | Total: " + ClicksPurchased);
                ClicksTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });

        burgerItemLabel = new JLabel();
        burgerItemLabel.setText("Buy Burger Item (1 cps) - 1000 clicks");
        burgerItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        burgerItemLabel.setForeground(Color.BLACK);

        LabelClickable.makeLabelClickable(burgerItemLabel, () -> {
            if (count >= 1000) {
                count -= 1000;
                BurgerPurchased++;
                cps += 1;
                counterLabel.setText("Count: " + count);
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                burgerItemLabel.setText("Buy Burger Item (1 cps) - 1000 clicks | Total: " + BurgerPurchased);
                BurgerTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
        

        LabelClickable.makeLabelClickable(x3Clicks, () -> {
            if (count >= 1200 && !x3ClicksActive) {

                count -= 1200;
                x3ClicksActive = true;

                // Add x3Clicks to currentPerks

                upgrades.remove(x3Clicks);
                JLabel x3ClicksActive = new JLabel();
                x3ClicksActive.setText("x3Clicks ACTIVE");
                x3ClicksActive.setFont(new Font("Arial", Font.BOLD, 15));
                x3ClicksActive.setForeground(Color.GREEN);

                upgrades.revalidate();
                upgrades.repaint();
                currentPerks.add(x3ClicksActive);
                currentPerks.revalidate();
                currentPerks.repaint();

                counterLabel.setText("Count: " + count);
                JOptionPane.showMessageDialog(null, "You bought x3 clicks!");

            } else if (x3ClicksActive) {
                JOptionPane.showMessageDialog(null, "You already have x3 clicks active!");
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });

        LabelClickable.makeLabelClickable(x2Clicks, () -> {
            if (count >= 100 && !x2ClicksActive) {

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

            } else if (x2ClicksActive) {
                JOptionPane.showMessageDialog(null, "You already have x2 clicks active!");
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });

        // clicks per second display 
        cpsLabel = new JLabel();
        cpsLabel.setBounds(200, 150, 200, 50);
        cpsLabel.setText("CPS: " + cps);
        cpsLabel.setFont(cpsLabel.getFont().deriveFont(20.0f));

        add(cpsLabel);
        add(Shoptabs);
        upgrades.add(x2Clicks);
        upgrades.add(x3Clicks);
        items.add(clicksItemLabel);
        items.add(burgerItemLabel);
        add(Bakery);
        add(imageClicker);
        add(counterLabel);

    }


    public void BurgerTimer(){
        Timer BurgerTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count += 1; // Each clicksItem adds 1 click per second
                counterLabel.setText("Count: " + count);
            }
        });
        BurgerTimer.start();
    }

    public void ClicksTimer() {
        Timer clicksTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp += 0.1; // Accumulate 0.1 per second

                if (temp >= 1) { // Check if we've reached or exceeded 1
                    count += 1; // Increment the count by 1
                    temp -= 1; // Deduct 1 from temp to keep the remainder
                }

                // Update the counter label to show the current count
                counterLabel.setText("Count: " + count);
            }
        });

        clicksTimer.start(); // Start the timer
    }

        public void startGameLoop() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable gameLoopTask = new Runnable() {
            @Override
            public void run() {
                updateGameLogic();
                renderGame();
            }
        };

        // Schedule the task to run at a fixed rate (every 16.67 ms for 60 FPS)
        scheduler.scheduleAtFixedRate(gameLoopTask, 0, 16, TimeUnit.MILLISECONDS);
    }

    // Method for updating the game logic
    public void updateGameLogic() {

    }

    // Method for rendering the game state
    public void renderGame() {

    }
    
    
    
    
}

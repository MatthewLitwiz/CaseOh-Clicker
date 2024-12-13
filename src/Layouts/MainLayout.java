package Layouts;

import Utilities.ImageClicker;
import Utilities.LabelClickable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class MainLayout extends JPanel {

    ImageClicker imageClicker = new ImageClicker();

    private final JTabbedPane Shoptabs;

    private int count = 2000000;
    private double temp = 0.0;

    private boolean x2ClicksActive = false;
    private boolean x3ClicksActive = false;

    private int ClicksPurchased = 0; // Number of Clicks Items purchased
    private int BurgerPurchased = 0; // Number of Burgers purchased
    private int PizzaPurchased = 0; // Number of Pizzas purchased
    private int TacoTruckPurchased = 0; // Number of Taco Trucks purchased
    private int DonutFactoryPurchased = 0; // Number of Donut Factories purchased
    private int FriedChickenPurchased = 0; // Number of Fried Chickens purchased
    private int MegaBuffetPurchased = 0; // Number of Mega Buffets purchased
    private double cps = 0; // tracks clicks per second

    // item shop
    JLabel clicksItemLabel, burgerItemLabel, cpsLabel, pizzaLabel, tacoTruckLabel, DonutFactoryLabel, FriedChickenLabel, MegaBuffetLabel;

    // click multiplier
    JLabel x2Clicks, x3Clicks;

    JPanel upgrades, currentPerks, items, stats;
    JLabel counterLabel, Bakery;

    // costs of items
    private final int clicksItemCost = 100;
    private final int burgerItemCost = 1000;
    private final int pizzaItemCost = 5000;
    private final int tacoTruckCost = 10000;
    private final int DonutFactoryCost = 50000;
    private final int FriedChickenCost = 200000; // Number of Fried Chickens purchased
    private final int MegaBuffetCost = 1000000; // Number of Mega Buffets purchased

    // buffs
    JLabel x2income, x2incomeActiveLabel;
    boolean x2incomeActive = false;

    private JLabel x3ClicksActiveLabel, x2ClicksActiveLabel;;

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

        stats = new JPanel();
        stats.setLayout(new javax.swing.BoxLayout(stats, javax.swing.BoxLayout.Y_AXIS));
        Shoptabs.addTab("Stats", stats);

        counterLabel = new JLabel();
        counterLabel.setBounds(200, 100, 200, 50);
        counterLabel.setText("Count: " + count);
        counterLabel.setFont(counterLabel.getFont().deriveFont(20.0f));

        // MAIN counting logic
        imageClicker.ClickableImage("src/Images/CaseOhFace.jpg", 450, 700, 50, 200, () -> {
            if (x3ClicksActive && x2ClicksActive) {
                count += 5; // x3Clicks overrides x2Clicks
            } else if (x2ClicksActive) {
                count += 2; // Only x2Clicks is active
            } else {
                count++; // No boosts active
            }

            counterLabel.setText("Count: " + String.format("%,d", count));
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

        TwoTimesClicks();

        // buy x3 clicks
        x3Clicks = new JLabel();
        x3Clicks.setText("Buy x3 Clicks - 2,000 clicks");
        x3Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x3Clicks.setForeground(Color.BLACK);

        ThreeTimesClicks();

        // Clicks Click

        clicksItemLabel = new JLabel();
        clicksItemLabel.setText("Buy Clicks Item (0.1 cps) - 100 clicks");
        clicksItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clicksItemLabel.setForeground(Color.BLACK);

        clickClick();

        // Burger Clicks

        burgerItemLabel = new JLabel();
        burgerItemLabel.setText("Buy Burger Item (1 cps) - 1,000 clicks");
        burgerItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        burgerItemLabel.setForeground(Color.BLACK);

        BurgerClick();

        // buy pizza item

        pizzaLabel = new JLabel();
        pizzaLabel.setText("Buy Pizza Item (5 cps) - 5,000 clicks");
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        pizzaLabel.setForeground(Color.BLACK);

        PizzaClicks();

        tacoTruckLabel = new JLabel();
        tacoTruckLabel.setText("Buy Taco Truck (10 cps) - 10,000 clicks");
        tacoTruckLabel.setFont(new Font("Arial", Font.BOLD, 15));
        tacoTruckLabel.setForeground(Color.BLACK);

        TacoTruckClick();

        DonutFactoryLabel = new JLabel();
        DonutFactoryLabel.setText("Buy Donut Factory (20 cps) - 50,000 clicks");
        DonutFactoryLabel.setFont(new Font("Arial", Font.BOLD, 15));
        DonutFactoryLabel.setForeground(Color.BLACK);

        DonutFactoryClick();

        FriedChickenLabel = new JLabel();
        FriedChickenLabel.setText("Buy Fried Chicken (50 cps) - 200,000 clicks");
        FriedChickenLabel.setFont(new Font("Arial", Font.BOLD, 15));
        FriedChickenLabel.setForeground(Color.BLACK);

        FriedChickenClick();

        MegaBuffetLabel = new JLabel();
        MegaBuffetLabel.setText("Buy Mega Buffet (100 cps) - 1,000,000 clicks");
        MegaBuffetLabel.setFont(new Font("Arial", Font.BOLD, 15));
        MegaBuffetLabel.setForeground(Color.BLACK);

        MegaBuffetClick();

        // buffs

        x2income = new JLabel();
        x2income.setText("x2 income - 500,000 clicks");
        x2income.setFont(new Font("Arial", Font.BOLD, 15));
        x2income.setForeground(Color.RED);

        doubleIncome();

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
        items.add(pizzaLabel);
        items.add(tacoTruckLabel);
        items.add(DonutFactoryLabel);
        items.add(FriedChickenLabel);
        items.add(MegaBuffetLabel);
        items.add(x2income);
        add(Bakery);
        add(imageClicker);
        add(counterLabel);

    }

    public void startGameLoop() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable gameLoopTask = () -> {
            updateGameLogic();
            renderGame();
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

    private void ThreeTimesClicks() {
        LabelClickable.makeLabelClickable(x3Clicks, () -> {
            if (count >= 2000 && !x3ClicksActive) {
                if(!x2ClicksActive){
                    JOptionPane.showMessageDialog(null, "You need to buy x2 clicks first!");
                    return;
                }

                count -= 2000;
                x3ClicksActive = true;

                // Add x3Clicks to currentPerks

                upgrades.remove(x3Clicks);
                x3ClicksActiveLabel = new JLabel();
                x3ClicksActiveLabel.setText("x3Clicks ACTIVE");
                x3ClicksActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
                x3ClicksActiveLabel.setForeground(Color.GREEN);

                upgrades.revalidate();
                upgrades.repaint();
                currentPerks.add(x3ClicksActiveLabel);
                currentPerks.revalidate();
                currentPerks.repaint();

                counterLabel.setText("Count: " + String.format("%,d", count));
                JOptionPane.showMessageDialog(null, "You bought x3 clicks!");

            }else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void TwoTimesClicks(){
        LabelClickable.makeLabelClickable(x2Clicks, () -> {
            if (count >= 100 && !x2ClicksActive) {

                count -= 100;
                x2ClicksActive = true;

                // Add x2Clicks to currentPerks
                upgrades.remove(x2Clicks);
                x2ClicksActiveLabel = new JLabel();
                x2ClicksActiveLabel.setText("x2Clicks ACTIVE");
                x2ClicksActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
                x2ClicksActiveLabel.setForeground(Color.GREEN);

                upgrades.revalidate();
                upgrades.repaint();
                currentPerks.add(x2ClicksActiveLabel);
                currentPerks.revalidate();
                currentPerks.repaint();

                counterLabel.setText("Count: " + String.format("%,d", count));
                JOptionPane.showMessageDialog(null, "You bought x2 clicks!");
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void doubleIncome() {
        LabelClickable.makeLabelClickable(x2income, () -> {
            if (count >= 500000 && !x2incomeActive) {
                count -= 500000;
                x2incomeActive = true;

                // Add x2income to currentPerks
                items.remove(x2income);
                x2incomeActiveLabel = new JLabel();
                x2incomeActiveLabel.setText("[x2 income ACTIVE]");
                x2incomeActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
                x2incomeActiveLabel.setForeground(Color.GREEN);
                currentPerks.add(x2incomeActiveLabel);

                items.revalidate();
                items.repaint();

                counterLabel.setText("Count: " + String.format("%,d", count));
                JOptionPane.showMessageDialog(null, "You bought x2 income!");

                // Recalculate CPS for all items
                updateCPSForAllPurchases();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void updateCPSForAllPurchases() {
        // Update CPS for all purchased items based on x2incomeActive status
        cps = 0;
        cps += ClicksPurchased * (x2incomeActive ? 0.2 : 0.1);
        cps += BurgerPurchased * (x2incomeActive ? 2 : 1);
        cps += PizzaPurchased * (x2incomeActive ? 10 : 5);
        cps += TacoTruckPurchased * (x2incomeActive ? 20 : 10);
        cps += DonutFactoryPurchased * (x2incomeActive ? 40 : 20);
        cps += FriedChickenPurchased * (x2incomeActive ? 100 : 50);
        cps += MegaBuffetPurchased * (x2incomeActive ? 200 : 100);

        // Update CPS label
        cpsLabel.setText(String.format("CPS: %.1f", cps));
    }

    private void ClicksTimer() {
        Timer clicksTimer = new Timer(1000, (ActionEvent e) -> {
            temp += x2incomeActive ? 0.2 : 0.1; // Accumulate 0.1 per second

            if (temp >= 1) { // Check if we've reached or exceeded 1
                count += 1; // Increment the count by 1
                temp -= 1; // Deduct 1 from temp to keep the remainder
            }

            // Update the counter label to show the current count
            counterLabel.setText("Count: " + String.format("%,d", count));
        });

        clicksTimer.start(); // Start the timer
    }

    private void BurgerTimer() {
        Timer BurgerTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 2 : 1;
            count += clicksPerSecond * BurgerPurchased; // Apply to all burgers, including old ones
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        BurgerTimer.start();
    }

    private void PizzaTimer() {
        Timer pizzaTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 10 : 5;
            count += clicksPerSecond * PizzaPurchased; // Each clicksItem adds 5 clicks per second
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        pizzaTimer.start();
    }

    private void TacoTruckTimer() {
        Timer tacoTruckTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 20 : 10;
            count += clicksPerSecond * TacoTruckPurchased; // Each clicksItem adds 10 clicks per second
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        tacoTruckTimer.start();
    }

    private void DonutFactoryTimer() {
        Timer DonutFactoryTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 40 : 20;
            count += clicksPerSecond * DonutFactoryPurchased; // Each clicksItem adds 20 clicks per second
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        DonutFactoryTimer.start();
    }

    private void FriedChickenTimer() {
        Timer FriedChickenTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 100 : 50;
            count += clicksPerSecond * FriedChickenPurchased; // Each clicksItem adds 50 clicks per second
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        FriedChickenTimer.start();
    }

    private void MegaBuffetTimer() {
        Timer MegaBuffetTimer = new Timer(1000, (ActionEvent e) -> {
            int clicksPerSecond = x2incomeActive ? 200 : 100;
            count += clicksPerSecond * MegaBuffetPurchased; // Each clicksItem adds 100 clicks per second
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        MegaBuffetTimer.start();
    }

    private void clickClick() {
        LabelClickable.makeLabelClickable(clicksItemLabel, () -> {
            if (count >= clicksItemCost) {
                count -= 100;
                ClicksPurchased++;
                cps += x2incomeActive ? 0.2 : 0.1;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                clicksItemLabel.setText("Buy Clicks Item (0.1 cps) - 100 clicks | Total: " + ClicksPurchased);
                ClicksTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void BurgerClick() {
        LabelClickable.makeLabelClickable(burgerItemLabel, () -> {
            if (count >= burgerItemCost) {
                count -= 1000;
                BurgerPurchased++;
                cps += x2incomeActive ? 2 : 1;  // Update CPS for the new burger

                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Update CPS label based on new CPS
                burgerItemLabel.setText("Buy Burger Item (1 cps) - 1,000 clicks | Total: " + BurgerPurchased);

                cpsLabel.revalidate();
                cpsLabel.repaint();

                // Start or continue the timer for counting CPS
                BurgerTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void PizzaClicks() {
        LabelClickable.makeLabelClickable(pizzaLabel, () -> {
            if (count >= pizzaItemCost) {
                count -= 5000;
                PizzaPurchased++;
                cps += x2incomeActive ? 10 : 5;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                pizzaLabel.setText("Buy Pizza Item (5 cps) - 5,000 clicks | Total: " + PizzaPurchased);
                PizzaTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void TacoTruckClick() {
        LabelClickable.makeLabelClickable(tacoTruckLabel, () -> {
            if (count >= tacoTruckCost) {
                count -= 10000;
                TacoTruckPurchased++;
                cps += x2incomeActive ? 20 : 10;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                tacoTruckLabel.setText("Buy Taco Truck (10 cps) - 10,000 clicks | Total: " + TacoTruckPurchased);
                TacoTruckTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void DonutFactoryClick() {
        LabelClickable.makeLabelClickable(DonutFactoryLabel, () -> {
            if (count >= DonutFactoryCost) {
                count -= 50000;
                DonutFactoryPurchased++;
                cps += x2incomeActive ? 40 : 20;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                DonutFactoryLabel.setText("Buy Donut Factory (20 cps) - 50,000 clicks | Total: " + DonutFactoryPurchased);
                DonutFactoryTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void FriedChickenClick() {
        LabelClickable.makeLabelClickable(FriedChickenLabel, () -> {
            if (count >= FriedChickenCost) {
                count -= 200000;
                FriedChickenPurchased++;
                cps += x2incomeActive ? 100 : 50;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                FriedChickenLabel.setText("Buy Fried Chicken (50 cps) - 200,000 clicks | Total: " + FriedChickenPurchased);
                FriedChickenTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void MegaBuffetClick() {
        LabelClickable.makeLabelClickable(MegaBuffetLabel, () -> {
            if (count >= MegaBuffetCost) {
                count -= 1000000;
                MegaBuffetPurchased++;
                cps += x2incomeActive ? 200 : 100;
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 2 decimal places
                MegaBuffetLabel.setText("Buy Mega Buffet (100 cps) - 1,000,000 clicks | Total: " + MegaBuffetPurchased);
                MegaBuffetTimer();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }
}

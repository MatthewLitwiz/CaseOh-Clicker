package Layouts;

import Utilities.ImageClicker;
import Utilities.LabelClickable;
<<<<<<< HEAD
=======

>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD
=======

>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class MainLayout extends JPanel {

    ImageClicker imageClicker = new ImageClicker();

    private final JTabbedPane Shoptabs;

<<<<<<< HEAD
    private int count = 700000000;
=======
    private int count = 2000000;
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
    private double temp = 0.0;

    private boolean x2ClicksActive = false;
    private boolean x3ClicksActive = false;
    private boolean x4ClickActive = false;
    private boolean x6ClickActive = false;
    private boolean x10ClickActive = false;
    private boolean x12ClickActive = false;
    private boolean x15ClickActive = false;
    private boolean x20ClickActive = false;
    private boolean x25ClickActive = false;
    private boolean x30ClickActive = false;
    private boolean x40ClickActive = false;
    private boolean x50ClickActive = false;
    private boolean x100ClickActive = false;

    // click multiplier
    JLabel x2Clicks, x3Clicks, x4Clicks, x6Clicks, x10Clicks, x12Clicks, x15Clicks, x20Clicks, x25Clicks, x30Clicks, x40Clicks, x50Clicks, x100Clicks;

    JPanel upgrades, currentPerks, items, stats;
    JLabel counterLabel, Bakery;

    // item shop Labels
    JLabel clicksItemLabel, burgerItemLabel, cpsLabel, pizzaLabel, tacoTruckLabel, DonutFactoryLabel, FriedChickenLabel, MegaBuffetLabel;

    // all the foods
    private Map<String, Integer> foodPurchases = new HashMap<>();

    // number of items purchased
    private int ClicksPurchased = 0; // Number of Clicks Items purchased
    private int BurgerPurchased = 0; // Number of Burgers purchased
    private int PizzaPurchased = 0; // Number of Pizzas purchased
    private int TacoTruckPurchased = 0; // Number of Taco Trucks purchased
    private int DonutFactoryPurchased = 0; // Number of Donut Factories purchased
    private int FriedChickenPurchased = 0; // Number of Fried Chickens purchased
    private int MegaBuffetPurchased = 0; // Number of Mega Buffets purchased
    private double cps = 0; // tracks clicks per second

<<<<<<< HEAD
    private JLabel incomeActiveLabel;

    // buffs
    JLabel x2income, x2incomeActiveLabel, x4income, x4incomeActiveLabel;
    boolean x2incomeActive = false;
    private JLabel x3ClicksActiveLabel;
=======
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
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0

    private JLabel x2ClicksActiveLabel, x4ClicksActiveLabel, x6ClicksActiveLabel, x10ClicksActiveLabel, x12ClicksActiveLabel, x15ClicksActiveLabel, 
                    x20ClicksActiveLabel, x25ClicksActiveLabel, x30ClicksActiveLabel, x40ClicksActiveLabel, x50ClicksActiveLabel, x100ClicksActiveLabel;

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
<<<<<<< HEAD
            if (x100ClickActive) {
                count += 100;
            } else if (x50ClickActive) {
                count += 50;
            } else if (x40ClickActive) {
                count += 40;
            } else if (x30ClickActive) {
                count += 30;
            } else if (x25ClickActive) {
                count += 25;
            } else if (x20ClickActive) {
                count += 20;
            } else if (x15ClickActive) {
                count += 15;
            } else if (x12ClickActive) {
                count += 12;
            } else if (x10ClickActive) {
                count += 10;
            } else if (x6ClickActive) {
                count += 6;
            } else if (x4ClickActive) {
                count += 4;
            } else if (x3ClicksActive) {
                count += 3;
=======
            if (x3ClicksActive && x2ClicksActive) {
                count += 5; // x3Clicks overrides x2Clicks
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
            } else if (x2ClicksActive) {
                count += 2;
            } else {
                count++; // No boosts active
            }
<<<<<<< HEAD
            // Update UI or perform other actions if necessary
=======

>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        

        // set upgrades to empty if empty
        if (upgrades.getComponentCount() == 0) {
            upgrades.add(new JLabel("No upgrades available"));
        }

        // shop Name

        Bakery = new JLabel();
        Bakery.setBounds(150, 50, 400, 50);
        Bakery.setText("Your Shop Name");
        Bakery.setFont(new Font("Tahoma", Font.BOLD, 40));
        Bakery.setForeground(Color.BLUE);
        changeShopName();

        // buy x2 clicks

        x2Clicks = new JLabel();
        x2Clicks.setText("Buy x2 Clicks - 100 clicks");
        x2Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x2Clicks.setForeground(Color.GRAY);
        TwoTimesClicks();

        // buy x3 clicks
        x3Clicks = new JLabel();
        x3Clicks.setText("Buy x3 Clicks - 2,000 clicks");
        x3Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x3Clicks.setForeground(Color.GRAY);
        ThreeTimesClicks();

        // 4x clicks
        x4Clicks = new JLabel();
        x4Clicks.setText("Buy x4 Clicks - 5,000 clicks");
        x4Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x4Clicks.setForeground(Color.GRAY);
        FourTimesClicks();

        // 6x clicks
        x6Clicks = new JLabel();
        x6Clicks.setText("Buy x6 Clicks - 10,000 clicks");
        x6Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x6Clicks.setForeground(Color.GRAY);
        SixTimesClicks();

        // 10x clicks
        x10Clicks = new JLabel();
        x10Clicks.setText("Buy x10 Clicks - 50,000 clicks");
        x10Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x10Clicks.setForeground(Color.GRAY);
        TenTimesClicks();

        // 12x clicks
        x12Clicks = new JLabel();
        x12Clicks.setText("Buy x12 Clicks - 100,000 clicks");
        x12Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x12Clicks.setForeground(Color.GRAY);
        TwelveTimesClicks();

        // 15x clicks
        x15Clicks = new JLabel();
        x15Clicks.setText("Buy x15 Clicks - 500,000 clicks");
        x15Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x15Clicks.setForeground(Color.GRAY);
        FifteenTimesClicks();

        // 20x clicks
        x20Clicks = new JLabel();
        x20Clicks.setText("Buy x20 Clicks - 1,000,000 clicks");
        x20Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x20Clicks.setForeground(Color.GRAY);
        TwentyTimesClicks();

        // 25x clicks
        x25Clicks = new JLabel();
        x25Clicks.setText("Buy x25 Clicks - 5,000,000 clicks");
        x25Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x25Clicks.setForeground(Color.GRAY);
        TwentyFiveTimesClicks();

        // 30x clicks
        x30Clicks = new JLabel();
        x30Clicks.setText("Buy x30 Clicks - 10,000,000 clicks");
        x30Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x30Clicks.setForeground(Color.GRAY);
        ThirtyTimesClicks();

        // 40x clicks
        x40Clicks = new JLabel();
        x40Clicks.setText("Buy x40 Clicks - 50,000,000 clicks");
        x40Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x40Clicks.setForeground(Color.GRAY);
        FortyTimesClicks();

        // 50x clicks
        x50Clicks = new JLabel();
        x50Clicks.setText("Buy x50 Clicks - 100,000,000 clicks");
        x50Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x50Clicks.setForeground(Color.GRAY);
        FiftyTimesClicks();

        // 100x clicks
        x100Clicks = new JLabel();
        x100Clicks.setText("Buy x100 Clicks - 500,000,000 clicks");
        x100Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x100Clicks.setForeground(Color.GRAY);
        HundredTimesClicks();

        // Clicks Click

        clicksItemLabel = new JLabel();
        clicksItemLabel.setText("Buy Clicks Item (0.1 cps) - 100 clicks");
        clicksItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clicksItemLabel.setForeground(Color.GRAY);

        setupFoodItem(clicksItemLabel, 100, 0.1, "Clicks", 1); // Arguments: label, cost, baseCPS, itemName, cpsMultiplier

        // Burger Clicks

        burgerItemLabel = new JLabel();
        burgerItemLabel.setText("Buy Burger Item (1 cps) - 1,000 clicks");
        burgerItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        burgerItemLabel.setForeground(Color.GRAY);

        setupFoodItem(burgerItemLabel, 1000, 1, "Burger", 1);  // base CPS = 1, cost = 1000

        // buy pizza item

        pizzaLabel = new JLabel();
        pizzaLabel.setText("Buy Pizza Item (5 cps) - 5,000 clicks");
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        pizzaLabel.setForeground(Color.GRAY);

        setupFoodItem(pizzaLabel, 5000, 5, "Pizza", 1);  // base CPS = 5, cost = 5000


        tacoTruckLabel = new JLabel();
        tacoTruckLabel.setText("Buy Taco Truck (10 cps) - 10,000 clicks");
        tacoTruckLabel.setFont(new Font("Arial", Font.BOLD, 15));
        tacoTruckLabel.setForeground(Color.GRAY);

        setupFoodItem(tacoTruckLabel, 10000, 10, "Taco Truck", 1);  // base CPS = 10, cost = 10000


        DonutFactoryLabel = new JLabel();
        DonutFactoryLabel.setText("Buy Donut Factory (20 cps) - 50,000 clicks");
        DonutFactoryLabel.setFont(new Font("Arial", Font.BOLD, 15));
        DonutFactoryLabel.setForeground(Color.GRAY);

        setupFoodItem(DonutFactoryLabel, 50000, 20, "Donut Factory", 1);  // base CPS = 20, cost = 50000


        FriedChickenLabel = new JLabel();
        FriedChickenLabel.setText("Buy Fried Chicken (50 cps) - 200,000 clicks");
        FriedChickenLabel.setFont(new Font("Arial", Font.BOLD, 15));
        FriedChickenLabel.setForeground(Color.GRAY);

        setupFoodItem(FriedChickenLabel, 200000, 50, "Fried Chicken", 1);  // base CPS = 50, cost = 200000


        MegaBuffetLabel = new JLabel();
        MegaBuffetLabel.setText("Buy Mega Buffet (100 cps) - 1,000,000 clicks");
        MegaBuffetLabel.setFont(new Font("Arial", Font.BOLD, 15));
        MegaBuffetLabel.setForeground(Color.GRAY);

        setupFoodItem(MegaBuffetLabel, 1000000, 100, "Mega Buffet", 1);  // base CPS = 100, cost = 1000000


        // buffs

        x2income = new JLabel();
        x2income.setText("x2 income - 500,000 clicks");
        x2income.setFont(new Font("Arial", Font.BOLD, 15));
        x2income.setForeground(Color.RED);

        buyIncomeMultiplier(x2income, 2, 500000, "x2");  // Multiplier is 2 (double), cost is 500,000

        x4income = new JLabel();
        x4income.setText("x4 income - 1,000,000 clicks");
        x4income.setFont(new Font("Arial", Font.BOLD, 15));
        x4income.setForeground(Color.RED);

        buyIncomeMultiplier(x4income, 4, 1000000, "x4");  // Multiplier is 4 (quadruple), cost is 1,000,000


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
        
<<<<<<< HEAD
        AddEverything();
    }

    private void AddEverything(){
=======
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
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
<<<<<<< HEAD
        upgrades.add(x2income);
        upgrades.add(x4Clicks);
        upgrades.add(x6Clicks);
        upgrades.add(x10Clicks);
        upgrades.add(x12Clicks);
        upgrades.add(x15Clicks);
        upgrades.add(x20Clicks);
        upgrades.add(x25Clicks);
        upgrades.add(x30Clicks);
        upgrades.add(x40Clicks);
        upgrades.add(x50Clicks);
        upgrades.add(x100Clicks);
        upgrades.add(x4income);
        add(Bakery);
        add(imageClicker);
        add(counterLabel);
=======
        items.add(x2income);
        add(Bakery);
        add(imageClicker);
        add(counterLabel);

>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
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

    // change the name of shop

    private void changeShopName() {
        LabelClickable.makeLabelClickable(Bakery, () -> {
            String shopName = JOptionPane.showInputDialog("Enter your shop name");
            if (shopName == null) {
                Bakery.setText("Your Shop Name");
            } else if(shopName.length() >= 13){
                JOptionPane.showMessageDialog(null, "Shop name can't be more than 12 characters");
                Bakery.setText("Your Shop Name");
            } else {
                Bakery.setText(shopName);
            }
        });
    }

    private void setupUpgrade(
        JLabel clickableLabel,
        int cost,
        JLabel prerequisiteLabel,
        String upgradeName,
        boolean prerequisiteActive,
        String prerequisiteFieldName,
        String upgradeFieldName,
        Runnable additionalLogic
    ) {
        clickableLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Check if prerequisiteFieldName is set
                    if (prerequisiteFieldName != null) {
                        // Verify prerequisite field is active
                        Field prereqField = MainLayout.class.getDeclaredField(prerequisiteFieldName);
                        prereqField.setAccessible(true);
    
                        boolean prereqActive = prereqField.getBoolean(MainLayout.this);
                        if (!prereqActive) {
                            JOptionPane.showMessageDialog(null, "Cannot unlock " + upgradeName + " without buying " + prerequisiteFieldName);
                            return;
                        }
                    }
    
                    // Set upgrade field to active
                    Field upgradeField = MainLayout.class.getDeclaredField(upgradeFieldName);
                    upgradeField.setAccessible(true);
                    upgradeField.setBoolean(MainLayout.this, true);
    
                    // Execute additional logic if provided
                    if (additionalLogic != null) {
                        additionalLogic.run();
                    }
    
                    // Deduct cost or perform additional operations
                    System.out.println(upgradeName + " successfully unlocked!");
    
                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    System.err.println("Error accessing fields: prerequisiteFieldName=" + prerequisiteFieldName
                            + ", upgradeFieldName=" + upgradeFieldName);
                }
<<<<<<< HEAD
=======

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
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
            }
        });
    }

    private void setupFoodItem(JLabel itemLabel, int itemCost, double baseCPS, String itemName, int cpsMultiplier) {
        LabelClickable.makeLabelClickable(itemLabel, () -> {
            if (count >= itemCost) {
                count -= itemCost;  // Deduct the cost
    
                // Increment the purchase count
                if (itemName.equals("Clicks")) {
                    ClicksPurchased++;
                } else if (itemName.equals("Burger")) {
                    BurgerPurchased++;
                } else if (itemName.equals("Pizza")) {
                    PizzaPurchased++;
                } else if (itemName.equals("Taco Truck")) {
                    TacoTruckPurchased++;
                } else if (itemName.equals("Donut Factory")) {
                    DonutFactoryPurchased++;
                } else if (itemName.equals("Fried Chicken")) {
                    FriedChickenPurchased++;
                } else if (itemName.equals("Mega Buffet")) {
                    MegaBuffetPurchased++;
                }
    
                // Check if double income is active, then adjust CPS accordingly
                double finalCPS = baseCPS * cpsMultiplier;
                if (x2incomeActive) {
                    finalCPS *= 2; // Double the CPS if income boost is active
                }
    
                // Update CPS
                cps += finalCPS;
    
                // Update the UI labels
                counterLabel.setText("Count: " + String.format("%,d", count));
                cpsLabel.setText(String.format("CPS: %.1f", cps)); // Format CPS to 1 decimal place
                itemLabel.setText("Buy " + itemName + " (" + baseCPS + " cps) - " + itemCost + " clicks | Total: " + getPurchasedCount(itemName));
    
                // Call the timer to start the CPS accumulation
                startItemTimer(baseCPS, cpsMultiplier);
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }
    
    private void startItemTimer(double baseCPS, int cpsMultiplier) {
        Timer itemTimer = new Timer(1000, (ActionEvent e) -> {
            double cpsIncrement = baseCPS * cpsMultiplier;
            if (x2incomeActive) {
                cpsIncrement *= 2; // Double the CPS if income boost is active
            }
            count += cpsIncrement;
            counterLabel.setText("Count: " + String.format("%,d", count));
        });
        itemTimer.start();
    }
    
    private int getPurchasedCount(String itemName) {
        switch (itemName) {
            case "Clicks":
                return ClicksPurchased;
            case "Burger":
                return BurgerPurchased;
            case "Pizza":
                return PizzaPurchased;
            case "Taco Truck":
                return TacoTruckPurchased;
            case "Donut Factory":
                return DonutFactoryPurchased;
            case "Fried Chicken":
                return FriedChickenPurchased;
            case "Mega Buffet":
                return MegaBuffetPurchased;
            default:
                return 0;
        }
    }

    
    private void HundredTimesClicks() {
        setupUpgrade(
            x100Clicks,               // The clickable label
            500000000,                // Cost of the upgrade
            x50ClicksActiveLabel,     // Prerequisite label
            "x100Clicks",             // Name of the upgrade
            x50ClickActive,           // Prerequisite active flag
            "x50ClickActive",         // Prerequisite field name
            "x100ClickActive",        // Upgrade field name
            null                      // Additional logic, if any
        );
    }
    
    private void FiftyTimesClicks() {
        setupUpgrade(
            x50Clicks,               // The clickable label
            100000000,               // Cost of the upgrade
            x40ClicksActiveLabel,    // Prerequisite label
            "x50Clicks",             // Name of the upgrade
            x40ClickActive,          // Prerequisite active flag
            "x40ClickActive",        // Prerequisite field name
            "x50ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void FortyTimesClicks() {
        setupUpgrade(
            x40Clicks,               // The clickable label
            50000000,                // Cost of the upgrade
            x30ClicksActiveLabel,    // Prerequisite label
            "x40Clicks",             // Name of the upgrade
            x30ClickActive,          // Prerequisite active flag
            "x30ClickActive",        // Prerequisite field name
            "x40ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void ThirtyTimesClicks() {
        setupUpgrade(
            x30Clicks,               // The clickable label
            10000000,                // Cost of the upgrade
            x25ClicksActiveLabel,    // Prerequisite label
            "x30Clicks",             // Name of the upgrade
            x25ClickActive,          // Prerequisite active flag
            "x25ClickActive",        // Prerequisite field name
            "x30ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void TwentyFiveTimesClicks() {
        setupUpgrade(
            x25Clicks,               // The clickable label
            5000000,                 // Cost of the upgrade
            x20ClicksActiveLabel,    // Prerequisite label
            "x25Clicks",             // Name of the upgrade
            x20ClickActive,          // Prerequisite active flag
            "x20ClickActive",        // Prerequisite field name
            "x25ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void TwentyTimesClicks() {
        setupUpgrade(
            x20Clicks,               // The clickable label
            1000000,                 // Cost of the upgrade
            x15ClicksActiveLabel,    // Prerequisite label
            "x20Clicks",             // Name of the upgrade
            x15ClickActive,          // Prerequisite active flag
            "x15ClickActive",        // Prerequisite field name
            "x20ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void FifteenTimesClicks() {
        setupUpgrade(
            x15Clicks,               // The clickable label
            500000,                  // Cost of the upgrade
            x12ClicksActiveLabel,    // Prerequisite label
            "x15Clicks",             // Name of the upgrade
            x12ClickActive,          // Prerequisite active flag
            "x12ClickActive",        // Prerequisite field name
            "x15ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void TwelveTimesClicks() {
        setupUpgrade(
            x12Clicks,               // The clickable label
            100000,                  // Cost of the upgrade
            x10ClicksActiveLabel,    // Prerequisite label
            "x12Clicks",             // Name of the upgrade
            x10ClickActive,          // Prerequisite active flag
            "x10ClickActive",        // Prerequisite field name
            "x12ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void TenTimesClicks() {
        setupUpgrade(
            x10Clicks,               // The clickable label
            50000,                   // Cost of the upgrade
            x6ClicksActiveLabel,     // Prerequisite label
            "x10Clicks",             // Name of the upgrade
            x6ClickActive,           // Prerequisite active flag
            "x6ClickActive",         // Prerequisite field name
            "x10ClickActive",        // Upgrade field name
            null                     // Additional logic, if any
        );
    }
    
    private void SixTimesClicks() {
        setupUpgrade(
            x6Clicks,               // The clickable label
            10000,                  // Cost of the upgrade
            x4ClicksActiveLabel,    // Prerequisite label
            "x6Clicks",             // Name of the upgrade
            x4ClickActive,          // Prerequisite active flag
            "x4ClickActive",        // Prerequisite field name
            "x6ClickActive",        // Upgrade field name
            null                    // Additional logic, if any
        );
    }
    
    private void FourTimesClicks() {
        setupUpgrade(
            x4Clicks,               // The clickable label
            5000,                   // Cost of the upgrade
            x3ClicksActiveLabel,    // Prerequisite label
            "x4Clicks",             // Name of the upgrade
            x3ClicksActive,         // Prerequisite active flag
            "x3ClicksActive",       // Prerequisite field name
            "x4ClickActive",        // Upgrade field name
            null                    // Additional logic, if any
        );
    }
    
    private void ThreeTimesClicks() {
        setupUpgrade(
            x3Clicks,               // The clickable label
            2000,                   // Cost of the upgrade
            x2ClicksActiveLabel,    // Prerequisite label
            "x3Clicks",             // Name of the upgrade
            x2ClicksActive,         // Prerequisite active flag
            "x2ClicksActive",       // Prerequisite field name
            "x3ClicksActive",       // Upgrade field name
            null                    // Additional logic, if any
        );
    }
    
    private void TwoTimesClicks() {
        setupUpgrade(
            x2Clicks,               // The clickable label
            100,                    // Cost of the upgrade
            null,                   // No prerequisite label
            "x2Clicks",             // Name of the upgrade
            false,                  // No prerequisite active flag
            null,                   // No prerequisite field name
            "x2ClicksActive",       // Upgrade field name
            null                    // Additional logic, if any
        );
    }
    

<<<<<<< HEAD
    private boolean incomeActive = false;  // To track if income multiplier is active
    private int incomeMultiplier = 1;  // Default multiplier (1 for no boost)
    
    private void buyIncomeMultiplier(JLabel incomeLabel, int multiplier, int cost, String multiplierText) {
        LabelClickable.makeLabelClickable(incomeLabel, () -> {
            if (count >= cost && !incomeActive) {
                count -= cost;
                incomeActive = true;
                incomeMultiplier = multiplier;  // Set the new multiplier
    
                // Remove the old multiplier item
                upgrades.remove(incomeLabel);
    
                // Call the method to update the active label outside the lambda
                createIncomeActiveLabel(multiplierText);
    
                items.revalidate();
                items.repaint();
    
                counterLabel.setText("Count: " + String.format("%,d", count));
                JOptionPane.showMessageDialog(null, "You bought " + multiplierText + " income!");
    
                // Recalculate CPS for all items
                updateCPSForAllPurchases();
=======
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
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

<<<<<<< HEAD
    private void createIncomeActiveLabel(String multiplierText) {
        // Create and update the incomeActiveLabel here
        incomeActiveLabel = new JLabel();
        incomeActiveLabel.setText("[" + multiplierText + " income ACTIVE]");
        incomeActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
        incomeActiveLabel.setForeground(Color.GREEN);
        currentPerks.add(incomeActiveLabel);
    }
    
    private void updateCPSForAllPurchases() {
        // Recalculate CPS for each item based on the active multiplier
        updateItemCPS("Clicks", 0.1, 1);  // Example CPS for "Clicks" with no multiplier
        updateItemCPS("Burger", 0.2, 1);
        updateItemCPS("Pizza", 0.3, 1);
        updateItemCPS("Taco Truck", 0.4, 1);
        updateItemCPS("Donut Factory", 0.5, 1);
        updateItemCPS("Fried Chicken", 0.6, 1);
        updateItemCPS("Mega Buffet", 0.7, 1);
    }
    
    private void updateItemCPS(String itemName, double baseCPS, int cpsMultiplier) {
        // Update CPS for all items considering the active multiplier
        double finalCPS = baseCPS * cpsMultiplier * incomeMultiplier;  // Apply the global income multiplier
    
        // Apply multiplier for specific items
        switch (itemName) {
            case "Clicks":
                cps += finalCPS;
                break;
            case "Burger":
                cps += finalCPS;
                break;
            case "Pizza":
                cps += finalCPS;
                break;
            case "Taco Truck":
                cps += finalCPS;
                break;
            case "Donut Factory":
                cps += finalCPS;
                break;
            case "Fried Chicken":
                cps += finalCPS;
                break;
            case "Mega Buffet":
                cps += finalCPS;
                break;
            default:
                break;
        }
    
        // Update the UI
        cpsLabel.setText(String.format("CPS: %.1f", cps));  // Format CPS to 1 decimal place
=======
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
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0
    }
    
    

<<<<<<< HEAD
}
=======
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
>>>>>>> f4433efba2916b00948c30bc6c6b7cf6178d48a0

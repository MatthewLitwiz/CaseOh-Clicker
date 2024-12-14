package Layouts;

import Utilities.ImageClicker;
import Utilities.LabelClickable;
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
import java.util.function.Supplier;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class MainLayout extends JPanel {

    ImageClicker imageClicker = new ImageClicker();

    private final JTabbedPane Shoptabs;

    private int count = 700000000;
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

    private JLabel incomeActiveLabel;
    private int incomeMultiplier = 1;  // Default multiplier (1 for no boost)

    // buffs
    JLabel x2income, x2incomeActiveLabel, x4income, x4incomeActiveLabel;
    private boolean x2incomeActive = false;
    private boolean x4incomeActive = false;
    private JLabel x3ClicksActiveLabel;

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
            } else if (x2ClicksActive) {
                count += 2;
            } else {
                count++; // No boosts active
            }
            // Update UI or perform other actions if necessary
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

        // buy x3 clicks
        x3Clicks = new JLabel();
        x3Clicks.setText("Buy x3 Clicks - 2,000 clicks");
        x3Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x3Clicks.setForeground(Color.GRAY);
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

        // 4x clicks
        x4Clicks = new JLabel();
        x4Clicks.setText("Buy x4 Clicks - 5,000 clicks");
        x4Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x4Clicks.setForeground(Color.GRAY);
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

        // 6x clicks
        x6Clicks = new JLabel();
        x6Clicks.setText("Buy x6 Clicks - 10,000 clicks");
        x6Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x6Clicks.setForeground(Color.GRAY);
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

        // 10x clicks
        x10Clicks = new JLabel();
        x10Clicks.setText("Buy x10 Clicks - 50,000 clicks");
        x10Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x10Clicks.setForeground(Color.GRAY);
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

        // 12x clicks
        x12Clicks = new JLabel();
        x12Clicks.setText("Buy x12 Clicks - 100,000 clicks");
        x12Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x12Clicks.setForeground(Color.GRAY);
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

        // 15x clicks
        x15Clicks = new JLabel();
        x15Clicks.setText("Buy x15 Clicks - 500,000 clicks");
        x15Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x15Clicks.setForeground(Color.GRAY);
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

        // 20x clicks
        x20Clicks = new JLabel();
        x20Clicks.setText("Buy x20 Clicks - 1,000,000 clicks");
        x20Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x20Clicks.setForeground(Color.GRAY);
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

        // 25x clicks
        x25Clicks = new JLabel();
        x25Clicks.setText("Buy x25 Clicks - 5,000,000 clicks");
        x25Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x25Clicks.setForeground(Color.GRAY);
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

        // 30x clicks
        x30Clicks = new JLabel();
        x30Clicks.setText("Buy x30 Clicks - 10,000,000 clicks");
        x30Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x30Clicks.setForeground(Color.GRAY);
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

        // 40x clicks
        x40Clicks = new JLabel();
        x40Clicks.setText("Buy x40 Clicks - 50,000,000 clicks");
        x40Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x40Clicks.setForeground(Color.GRAY);
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

        // 50x clicks
        x50Clicks = new JLabel();
        x50Clicks.setText("Buy x50 Clicks - 100,000,000 clicks");
        x50Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x50Clicks.setForeground(Color.GRAY);
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

        // 100x clicks
        x100Clicks = new JLabel();
        x100Clicks.setText("Buy x100 Clicks - 500,000,000 clicks");
        x100Clicks.setFont(new Font("Arial", Font.BOLD, 15));
        x100Clicks.setForeground(Color.GRAY);
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

        // Clicks Click

        clicksItemLabel = new JLabel();
        clicksItemLabel.setText("Buy Clicks Item (1 cps) - 100 clicks");
        clicksItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clicksItemLabel.setForeground(Color.GRAY);

        setupFoodItem(clicksItemLabel, 100, 1, "Clicks", 1); // Arguments: label, cost, baseCPS, itemName, cpsMultiplier

        // Burger Clicks

        burgerItemLabel = new JLabel();
        burgerItemLabel.setText("Buy Burger Item (3 cps) - 1,000 clicks");
        burgerItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        burgerItemLabel.setForeground(Color.GRAY);

        setupFoodItem(burgerItemLabel, 1000, 3, "Burger", 1);  // base CPS = 1, cost = 1000

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

        buyIncomeMultiplier(x2income, 2, 500000, "x2", () -> true); // Always true because x2 has no prerequisite

        x4income = new JLabel();
        x4income.setText("x4 income - 1,000,000 clicks");
        x4income.setFont(new Font("Arial", Font.BOLD, 15));
        x4income.setForeground(Color.RED);

        buyIncomeMultiplier(x4income, 4, 1000000, "x4", () -> x2incomeActive);

        // clicks per second display
        cpsLabel = new JLabel();
        cpsLabel.setBounds(200, 150, 200, 50);
        cpsLabel.setText("CPS: " + cps);
        cpsLabel.setFont(cpsLabel.getFont().deriveFont(20.0f));
        
        AddEverything();
    }

    private void AddEverything(){
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
    
                // Recalculate CPS for all items after the new purchase
                updateCPSForAllPurchases();
    
                // Update UI labels
                counterLabel.setText("Count: " + String.format("%,d", count));
                itemLabel.setText("Buy " + itemName + " (" + baseCPS + " cps) - " + itemCost + " clicks | Total: " + getPurchasedCount(itemName));
                startItemTimer(baseCPS, cpsMultiplier);
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }
    
    private void startItemTimer(double baseCPS, int cpsMultiplier) {
        Timer itemTimer = new Timer(1000, (ActionEvent e) -> {
            double cpsIncrement = baseCPS * cpsMultiplier * incomeMultiplier;
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

    private void buyIncomeMultiplier(JLabel incomeLabel, int multiplier, int cost, String multiplierText, Supplier<Boolean> prerequisiteSupplier) {
        LabelClickable.makeLabelClickable(incomeLabel, () -> {
            // Dynamically check the prerequisite condition
            if (!prerequisiteSupplier.get()) {
                JOptionPane.showMessageDialog(null, "You must buy the lower multiplier first!");
                return;
            }
    
            // Check if the user has enough clicks and isn't buying a lower multiplier than already active
            if (count >= cost && incomeMultiplier < multiplier) {
                count -= cost;  // Deduct the cost
                incomeMultiplier = multiplier;  // Set the new multiplier
    
                // Activate the current multiplier
                if (multiplier == 2) {
                    x2incomeActive = true;
                } else if (multiplier == 4) {
                    x4incomeActive = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid multiplier!");
                    return;
                }
    
                // Remove the old multiplier item
                upgrades.remove(incomeLabel);
    
                // Update the active multiplier label
                createIncomeActiveLabel(multiplierText);
    
                items.revalidate();
                items.repaint();
    
                counterLabel.setText("Count: " + String.format("%,d", count));
                JOptionPane.showMessageDialog(null, "You bought " + multiplierText + " income!");
    
                // Recalculate CPS for all items with the new multiplier
                updateCPSForAllPurchases();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks or already have a higher multiplier!");
            }
        });
    }
    
    
    

    private void createIncomeActiveLabel(String multiplierText) {
        // Create and update the incomeActiveLabel here
        incomeActiveLabel = new JLabel();
        incomeActiveLabel.setText("[" + multiplierText + " income ACTIVE]");
        incomeActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
        incomeActiveLabel.setForeground(Color.GREEN);
        currentPerks.add(incomeActiveLabel);
    }
    
    private void updateCPSForAllPurchases() {
        cps = 0; // Reset CPS before recalculating
        updateItemCPS("Clicks", 1, 1);
        updateItemCPS("Burger", 3, 1);
        updateItemCPS("Pizza", 5, 1);
        updateItemCPS("Taco Truck", 10, 1);
        updateItemCPS("Donut Factory", 20, 1);
        updateItemCPS("Fried Chicken", 50, 1);
        updateItemCPS("Mega Buffet", 100, 1);
    }
    
    private void updateItemCPS(String itemName, double baseCPS, int cpsMultiplier) {
        int purchasedCount = getPurchasedCount(itemName); // Get total items purchased
        double finalCPS = baseCPS * cpsMultiplier * incomeMultiplier * purchasedCount; // Apply multiplier
        cps += finalCPS; // Accumulate total CPS
        cpsLabel.setText(String.format("CPS: %.1f", cps)); // Update UI
    }
    
}
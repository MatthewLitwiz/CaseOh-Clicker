package Layouts;

import Util.AudioPlayer;
import Util.ImageClicker;
import Util.IncomeMultiplierHandler;
import Util.ItemHandlerClass;
import Util.LabelClickable;
import Util.UpgradeHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class MainLayout extends JPanel {

    // imports variables from other classes

    private ImageClicker imageClicker = new ImageClicker();
    private UpgradeHandler upgradeHandler = new UpgradeHandler(this);
    private ItemHandlerClass itemHandler;
    private IncomeMultiplierHandler incomeMultiplierHandler;

    private static final String audioPath = "src/Audio/BackgroundMusic.wav";
    private static final String punchSoundPath = "src/Audio/punch.wav";

    private final JTabbedPane Shoptabs;

    private int count = 2000000;

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

    private double cps = 0; // tracks clicks per second

    private JLabel incomeActiveLabel;

    // buffs
    JLabel x2income,  x4income;

    private JLabel x3ClicksActiveLabel;

    private final String CaseOhFace = "src/Images/CaseOhFace.jpg";

    private JLabel x2ClicksActiveLabel, x4ClicksActiveLabel, x6ClicksActiveLabel, x10ClicksActiveLabel, x12ClicksActiveLabel, x15ClicksActiveLabel, 
                    x20ClicksActiveLabel, x25ClicksActiveLabel, x30ClicksActiveLabel, x40ClicksActiveLabel, x50ClicksActiveLabel;

    public MainLayout() {
        setLayout(null);

        AudioPlayer.playAudioLoop(audioPath);

        incomeMultiplierHandler = new IncomeMultiplierHandler(this);

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

        // clicks per second display
        cpsLabel = new JLabel();
        cpsLabel.setBounds(200, 150, 200, 50);
        cpsLabel.setText("CPS: " + cps);
        cpsLabel.setFont(cpsLabel.getFont().deriveFont(20.0f));

        itemHandler = new ItemHandlerClass(this, incomeMultiplierHandler);

        logoChangerTimer();

        imageClicker.ClickableImage(CaseOhFace, 450, 700, 50, 200, () -> {
            AudioPlayer.playSoundOnceAsync(punchSoundPath);

            // Increase count based on boost
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

            // Update UI
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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
        upgradeHandler.setupUpgrade(
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

        // Assuming 'upgradeHandler' is instantiated from MainLayout
        upgradeHandler.setupUpgrade(
            x100Clicks,                // The clickable label
            500000000,                 // Cost of the upgrade
            x50ClicksActiveLabel,      // Prerequisite label
            "x100Clicks",              // Name of the upgrade
            x50ClickActive,            // Prerequisite active flag
        "x50ClickActive",          // Prerequisite field name
        "x100ClickActive",         // Upgrade field name
        null                       // Additional logic, if any
);


        // Clicks Click

        clicksItemLabel = new JLabel();
        clicksItemLabel.setText("Buy Clicks (1 cps) - 100 clicks");
        clicksItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        clicksItemLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(clicksItemLabel, 100, 1, "Clicks", 1); // Arguments: label, cost, baseCPS, itemName, cpsMultiplier

        // Burger Clicks

        burgerItemLabel = new JLabel();
        burgerItemLabel.setText("Buy Burger (3 cps) - 1,000 clicks");
        burgerItemLabel.setFont(new Font("Arial", Font.BOLD, 15));
        burgerItemLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(burgerItemLabel, 1000, 3, "Burger", 1);  // base CPS = 1, cost = 1000

        // buy pizza item

        pizzaLabel = new JLabel();
        pizzaLabel.setText("Buy Pizza (5 cps) - 5,000 clicks");
        pizzaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        pizzaLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(pizzaLabel, 5000, 5, "Pizza", 1);  // base CPS = 5, cost = 5000


        tacoTruckLabel = new JLabel();
        tacoTruckLabel.setText("Buy Taco Truck (10 cps) - 10,000 clicks");
        tacoTruckLabel.setFont(new Font("Arial", Font.BOLD, 15));
        tacoTruckLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(tacoTruckLabel, 10000, 10, "Taco Truck", 1);  // base CPS = 10, cost = 10000


        DonutFactoryLabel = new JLabel();
        DonutFactoryLabel.setText("Buy Donut Factory (20 cps) - 50,000 clicks");
        DonutFactoryLabel.setFont(new Font("Arial", Font.BOLD, 15));
        DonutFactoryLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(DonutFactoryLabel, 50000, 20, "Donut Factory", 1);  // base CPS = 20, cost = 50000


        FriedChickenLabel = new JLabel();
        FriedChickenLabel.setText("Buy Fried Chicken (50 cps) - 200,000 clicks");
        FriedChickenLabel.setFont(new Font("Arial", Font.BOLD, 15));
        FriedChickenLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(FriedChickenLabel, 200000, 50, "Fried Chicken", 1);  // base CPS = 50, cost = 200000


        MegaBuffetLabel = new JLabel();
        MegaBuffetLabel.setText("Buy Mega Buffet (100 cps) - 1,000,000 clicks");
        MegaBuffetLabel.setFont(new Font("Arial", Font.BOLD, 15));
        MegaBuffetLabel.setForeground(Color.GRAY);

        itemHandler.setupFoodItem(MegaBuffetLabel, 1000000, 100, "Mega Buffet", 1);


        // buffs

        x2income = new JLabel();
        x2income.setText("x2 income - 500,000 clicks");
        x2income.setFont(new Font("Arial", Font.BOLD, 15));
        x2income.setForeground(Color.RED);

        incomeMultiplierHandler.buyIncomeMultiplier(x2income, 2, 500000, "x2", () -> true); // No prerequisite for x2

        x4income = new JLabel();
        x4income.setText("x4 income - 1,000,000 clicks");
        x4income.setFont(new Font("Arial", Font.BOLD, 15));
        x4income.setForeground(Color.RED);

        incomeMultiplierHandler.buyIncomeMultiplier(x4income, 4, 1000000, "x4", () -> incomeMultiplierHandler.getIncomeMultiplier() >= 2);

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

    public JPanel getItemsPanel() {
        return items;
    }
    

    public int getCount() {
        return count;
    }

    public void updateCount(int newCount) {
        this.count = newCount;
        counterLabel.setText("Count: " + String.format("%,d", count));
        counterLabel.revalidate();
        counterLabel.repaint();
    }
    public JLabel getCounterLabel() {
        return counterLabel;
    }

    public JLabel getCpsLabel() {
        return cpsLabel;
    }

    public void updateCounterLabel(int currentCount) {
        counterLabel.setText("Count: " + String.format("%,d", currentCount));
        counterLabel.revalidate();
        counterLabel.repaint();
    }
    
    public void removeUpgradeLabel(JLabel label) {
        upgrades.remove(label);
    }
    
    public void addNewUpgradeLabel(JLabel label) {
        currentPerks.add(label);
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

    public final void logoChangerTimer() {
        Timer logoChanger = new Timer(1000, (ActionEvent e) -> {
            int currentCount = getCount(); // Get the current count from MainLayout
            updateLabelColor(clicksItemLabel, 100, currentCount);
            updateLabelColor(burgerItemLabel, 1000, currentCount);
            updateLabelColor(pizzaLabel, 5000, currentCount);
            updateLabelColor(tacoTruckLabel, 10000, currentCount);
            updateLabelColor(DonutFactoryLabel, 50000, currentCount);
            updateLabelColor(FriedChickenLabel, 200000, currentCount);
            updateLabelColor(MegaBuffetLabel, 1000000, currentCount);
            updateLabelColor(x2Clicks, 100, currentCount);
            updateLabelColor(x3Clicks, 2000, currentCount);
            updateLabelColor(x4Clicks, 5000, currentCount);
            updateLabelColor(x6Clicks, 10000, currentCount);
            updateLabelColor(x10Clicks, 50000, currentCount);
            updateLabelColor(x12Clicks, 100000, currentCount);
            updateLabelColor(x15Clicks, 500000, currentCount);
            updateLabelColor(x20Clicks, 1000000, currentCount);
            updateLabelColor(x25Clicks, 5000000, currentCount);
            updateLabelColor(x30Clicks, 10000000, currentCount);
            updateLabelColor(x40Clicks, 50000000, currentCount);
            updateLabelColor(x50Clicks, 100000000, currentCount);
            updateLabelColor(x100Clicks, 500000000, currentCount);
        });
        logoChanger.start();
    }
    
    
    private void updateLabelColor(JLabel label, int threshold, int currentCount) {
        if (label != null) {
            if (currentCount >= threshold) {
                label.setForeground(Color.GREEN);  // Change to GREEN if count is above threshold
            } else {
                label.setForeground(Color.GRAY);   // Otherwise, change to GRAY
            }
        }
    }
    

    private int getPurchasedCount(String itemName) {
        switch (itemName) {
            case "Clicks":
                return itemHandler.getClicksPurchased();
            case "Burger":
                return itemHandler.getBurgerPurchased();
            case "Pizza":
                return itemHandler.getPizzaPurchased();
            case "Taco Truck":
                return itemHandler.getTacoTruckPurchased();
            case "Donut Factory":
                return itemHandler.getDonutFactoryPurchased();
            case "Fried Chicken":
                return itemHandler.getFriedChickenPurchased();
            case "Mega Buffet":
                return itemHandler.getMegaBuffetPurchased();
            default:
                return 0;
        }
    }
    
    public void updateCPSForAllPurchases() {
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
        double finalCPS = baseCPS * cpsMultiplier * incomeMultiplierHandler.getIncomeMultiplier() * purchasedCount; // Use MainLayout's multiplier
        cps += finalCPS; // Accumulate total CPS
        cpsLabel.setText(String.format("CPS: %.1f", cps)); // Update the CPS UI
    }
    
    
}
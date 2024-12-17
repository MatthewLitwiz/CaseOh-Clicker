package Util;

import Layouts.MainLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ItemHandlerClass {
    private MainLayout mainLayout; // Reference to MainLayout
    private IncomeMultiplierHandler incomeMultiplierHandler;
    private double cps;
    private int ClicksPurchased = 0; // Number of Clicks Items purchased
    private int BurgerPurchased = 0; // Number of Burgers purchased
    private int PizzaPurchased = 0; // Number of Pizzas purchased
    private int TacoTruckPurchased = 0; // Number of Taco Trucks purchased
    private int DonutFactoryPurchased = 0; // Number of Donut Factories purchased
    private int FriedChickenPurchased = 0; // Number of Fried Chickens purchased
    private int MegaBuffetPurchased = 0; // Number of Mega Buffets purchased

    private final JLabel counterLabel;
    private final JLabel cpsLabel;

    private static final String clickSoundPath = "src/Audio/Click Sound.wav";

    public ItemHandlerClass(MainLayout mainLayout, IncomeMultiplierHandler incomeMultiplierHandler) {
        if (mainLayout == null || incomeMultiplierHandler == null) {
            throw new IllegalArgumentException("MainLayout and IncomeMultiplierHandler must not be null.");
        }
        this.mainLayout = mainLayout;
        this.incomeMultiplierHandler = incomeMultiplierHandler;
        this.counterLabel = mainLayout.getCounterLabel();
        this.cpsLabel = mainLayout.getCpsLabel();
    }
    

    public void setupFoodItem(JLabel itemLabel, int itemCost, int baseCPS, String itemName, int cpsMultiplier) {
        LabelClickable.makeLabelClickable(itemLabel, () -> {
            int count = mainLayout.getCount(); // Get count from MainLayout
            if (count >= itemCost) {
                mainLayout.updateCount(count - itemCost); // Deduct cost
                incrementPurchaseCount(itemName);

                // Recalculate CPS for all items after the new purchase
                updateCPSForAllPurchases();

                // Update UI labels
                itemLabel.setText("Buy " + itemName + " (" + baseCPS + " cps) - " +
                        String.format("%,d", itemCost) + " clicks | Total: " + getPurchasedCount(itemName));
                
                AudioPlayer.playSoundOnceAsync(clickSoundPath);
                startItemTimer(baseCPS, cpsMultiplier);
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks!");
            }
        });
    }

    private void startItemTimer(double baseCPS, int cpsMultiplier) {
        Timer itemTimer = new Timer(1000, (ActionEvent e) -> {
            double cpsIncrement = baseCPS * cpsMultiplier * incomeMultiplierHandler.getIncomeMultiplier();
            mainLayout.updateCount(mainLayout.getCount() + (int) cpsIncrement); // Increment count
        });
        itemTimer.start();
    }
    
    private void updateItemCPS(String itemName, double baseCPS, int cpsMultiplier) {
        int purchasedCount = getPurchasedCount(itemName); // Get total items purchased
        double finalCPS = baseCPS * cpsMultiplier * incomeMultiplierHandler.getIncomeMultiplier() * purchasedCount;
        cps += finalCPS; // Accumulate total CPS
        cpsLabel.setText(String.format("CPS: %.1f", cps)); // Update UI
    }
    
    

    private void incrementPurchaseCount(String itemName) {
        switch (itemName) {
            case "Clicks":
                ClicksPurchased++;
                break;
            case "Burger":
                BurgerPurchased++;
                break;
            case "Pizza":
                PizzaPurchased++;
                break;
            case "Taco Truck":
                TacoTruckPurchased++;
                break;
            case "Donut Factory":
                DonutFactoryPurchased++;
                break;
            case "Fried Chicken":
                FriedChickenPurchased++;
                break;
            case "Mega Buffet":
                MegaBuffetPurchased++;
                break;
            default:
                throw new IllegalArgumentException("Unknown item: " + itemName);
        }
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

    public int getClicksPurchased() {
        return ClicksPurchased;
    }

    public int getBurgerPurchased() {
        return BurgerPurchased;
    }

    public int getPizzaPurchased() {
        return PizzaPurchased;
    }

    public int getTacoTruckPurchased() {
        return TacoTruckPurchased;
    }

    public int getDonutFactoryPurchased() {
        return DonutFactoryPurchased;
    }

    public int getFriedChickenPurchased() {
        return FriedChickenPurchased;
    }

    public int getMegaBuffetPurchased() {
        return MegaBuffetPurchased;
    }
}

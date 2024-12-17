package Util;

import Layouts.MainLayout;
import java.awt.Font;
import java.util.function.Supplier;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IncomeMultiplierHandler {

    private MainLayout mainLayout;
    private int incomeMultiplier = 1; // Default multiplier (1 for no boost)
    private JLabel incomeActiveLabel;

    // Track which multipliers are active
    private boolean x2incomeActive = false;
    private boolean x4incomeActive = false;

    public IncomeMultiplierHandler(MainLayout mainLayout) {
        this.mainLayout = mainLayout;
    }

    // Getter for incomeMultiplier
    public int getIncomeMultiplier() {
        return incomeMultiplier;
    }

    public void buyIncomeMultiplier(JLabel incomeLabel, int multiplier, int cost, String multiplierText, Supplier<Boolean> prerequisiteSupplier) {
        LabelClickable.makeLabelClickable(incomeLabel, () -> {
            // Check prerequisite condition
            if (!prerequisiteSupplier.get()) {
                JOptionPane.showMessageDialog(null, "You must buy the lower multiplier first!");
                return;
            }

            // Check if the user has enough clicks and isn't buying a lower multiplier than already active
            int count = mainLayout.getCount();
            if (count >= cost && incomeMultiplier < multiplier) {
                mainLayout.updateCount(count - cost); // Deduct the cost
                incomeMultiplier = multiplier;       // Set the new multiplier

                // Activate the current multiplier
                if (multiplier == 2) {
                    x2incomeActive = true;  // Activate x2 multiplier
                    x4incomeActive = false; // Deactivate x4 if set
                } else if (multiplier == 4) {
                    x4incomeActive = true;  // Activate x4 multiplier
                    x2incomeActive = false; // Deactivate x2 if set
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid multiplier!");
                    return;
                }

                // Remove the old multiplier item
                mainLayout.removeUpgradeLabel(incomeLabel);

                // Update the active multiplier label
                createIncomeActiveLabel(multiplierText);

                mainLayout.getItemsPanel().revalidate();
                mainLayout.getItemsPanel().repaint();

                JOptionPane.showMessageDialog(null, "You bought " + multiplierText + " income!");

                // Recalculate CPS for all items with the new multiplier
                mainLayout.updateCPSForAllPurchases();
            } else {
                JOptionPane.showMessageDialog(null, "You don't have enough clicks or already have a higher multiplier!");
            }
        });
    }

    private void createIncomeActiveLabel(String multiplierText) {
        incomeActiveLabel = new JLabel();
        incomeActiveLabel.setText("[" + multiplierText + " income ACTIVE]");
        incomeActiveLabel.setFont(new Font("Arial", Font.BOLD, 15));
        incomeActiveLabel.setForeground(java.awt.Color.GREEN);
        mainLayout.addNewUpgradeLabel(incomeActiveLabel);
    }
}

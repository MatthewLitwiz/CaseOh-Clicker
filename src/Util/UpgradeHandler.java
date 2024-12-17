package Util;

import Layouts.MainLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpgradeHandler {

    private MainLayout mainLayout;
    String clickSoundPath = "src/Audio/Click Sound.wav";

    public UpgradeHandler(MainLayout mainLayout) {
        this.mainLayout = mainLayout;
    }

    public void setupUpgrade(
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
                        boolean prereqActive = prereqField.getBoolean(mainLayout);
                        if (!prereqActive) {
                            JOptionPane.showMessageDialog(null, "Cannot unlock " + upgradeName + " without buying " + prerequisiteFieldName);
                            return;
                        }
                    }

                    // Check if you have enough currency (count)
                    Field countField = MainLayout.class.getDeclaredField("count");
                    countField.setAccessible(true);
                    int currentCount = countField.getInt(mainLayout);

                    if (currentCount < cost) {
                        JOptionPane.showMessageDialog(null, "Not enough currency to buy " + upgradeName);
                        return;
                    }

                    // Deduct the cost from the main currency (count)
                    currentCount -= cost;
                    countField.setInt(mainLayout, currentCount);

                    // Update the counter label
                    mainLayout.updateCounterLabel(currentCount);

                    // Set upgrade field to active
                    Field upgradeField = MainLayout.class.getDeclaredField(upgradeFieldName);
                    upgradeField.setAccessible(true);
                    upgradeField.setBoolean(mainLayout, true);

                    // Execute additional logic if provided
                    if (additionalLogic != null) {
                        additionalLogic.run();
                    }

                    // Create the upgrade change label
                    createUpgradeChangeLabel(clickableLabel, upgradeName);

                    JOptionPane.showMessageDialog(null, "You bought " + upgradeName + "!");
                    AudioPlayer.playSoundOnceAsync(clickSoundPath);

                    mainLayout.revalidate();
                    mainLayout.repaint();

                } catch (NoSuchFieldException | IllegalAccessException ex) {
                    System.err.println("Error accessing fields: prerequisiteFieldName=" + prerequisiteFieldName
                            + ", upgradeFieldName=" + upgradeFieldName);
                }
            }
        });
    }

    private void createUpgradeChangeLabel(JLabel removeLabel, String upgradeName) {
        mainLayout.removeUpgradeLabel(removeLabel);
        
        JLabel addLabel = new JLabel("[" + upgradeName + " ACTIVE]");
        addLabel.setFont(new Font("Arial", Font.BOLD, 15));
        addLabel.setForeground(Color.GREEN);
        mainLayout.addNewUpgradeLabel(addLabel);
    }
}

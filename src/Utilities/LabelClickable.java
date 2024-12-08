package Utilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class LabelClickable {

    public static void makeLabelClickable(JLabel label, Runnable onClick){
        if (label == null || onClick == null){
            throw new IllegalArgumentException("Label and onClick action must not be null.");
        }

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick.run();
            }
        });
    }
    
}
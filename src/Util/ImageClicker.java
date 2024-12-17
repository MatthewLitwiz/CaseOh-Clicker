package Util;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ImageClicker extends JLabel{

    public void ClickableImage(String imagePath, int width, int height, int x, int y, Runnable onClick){
        try {

            // load the image
            ImageIcon originalIcon = new ImageIcon(imagePath);

            // resize image
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);

            // set the resized image to the Label
            this.setIcon(resizedIcon);
            
            // set bounds for absolute positioning
            this.setBounds(x, y, width, height);

            // click listener
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (onClick != null){
                        onClick.run();
                    }
                }
            });
        } catch (Exception e){
        }
    }
    
}

package Layouts;
import javax.swing.JPanel;

import Utilities.ImageClicker;

public class MainLayout extends JPanel {

    ImageClicker imageClicker = new ImageClicker();

    public MainLayout() {
        setLayout(null);
        
        imageClicker.ClickableImage("src/Images/CaseOhFace.jpg", 200, 400, 0, 0, () -> {
            System.out.println("CaseOh Clicked");
        });

        add(imageClicker);

    }
    
}

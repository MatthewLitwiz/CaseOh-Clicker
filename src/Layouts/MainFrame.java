package Layouts;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    MainLayout mainlayout = new MainLayout();

    public MainFrame() {

        mainlayout.startGameLoop();
        
        setTitle("CaseOh Clicker");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(mainlayout);
        setVisible(true);
    }
    
}

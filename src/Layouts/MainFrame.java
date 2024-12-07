package Layouts;
import javax.swing.JFrame;



public class MainFrame extends JFrame {

    MainLayout mainlayout = new MainLayout();

    public MainFrame() {
        setTitle("CaseOh Clicker");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(mainlayout);
        setVisible(true);
    }
    
}

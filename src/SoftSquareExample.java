import javax.swing.*;
import java.awt.*;

public class SoftSquareExample extends JFrame {

    public SoftSquareExample() {
        setTitle("Soft Square");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SoftSquareExample();
        });
    }
}

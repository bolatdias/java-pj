import javax.swing.*;

public class Button extends JButton {
    public Button(int x,int y,int w,int h, String iconPath) {
        setBounds(x,y,w,h);
        ImageIcon imageIcon=new ImageIcon(iconPath);
        setIcon(imageIcon);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
    }
}

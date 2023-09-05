import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static DBManager dbManager=new DBManager();
    public static MainFrame frame;
    public static List<Card> cardList;

    public static Font font;
    public static Font boltFont;
    public static Font extraBoltFont;


    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/LoewNext-Regular.ttf"));
            boltFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/LoewNext-Bold.ttf"));
            extraBoltFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/LoewNext-ExtraBold.ttf"));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // Handle font loading error
        }

    }

    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);

    }
}
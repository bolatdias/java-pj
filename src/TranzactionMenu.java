import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class TranzactionMenu extends JDesktopPane implements Runnable{

    private JLabel sumOfTransText;
    private JTextField sumOfTransField;

    private Button transButton;


    private CardLabel cardLabel;
    private CardLabel cardLabel2;


    private Button backButton;



    void refreshCardLabel(){
        cardLabel.changeCard(cardLabel.currentID);
        cardLabel2.changeCard(cardLabel2.currentID);
    }

    @Override
    public void run() {

        setSize(500, 960);
        setLayout(null);

        cardLabel = new CardLabel(21, 129);
        cardLabel2 = new CardLabel(21, 503);
        add(cardLabel);
        add(cardLabel2);

        JLabel mainText=new JLabel("Переводы");
        mainText.setBounds(182,43,135,37);
        mainText.setFont(Main.boltFont.deriveFont(Font.PLAIN,24));
        add(mainText);


        JLabel subText=new JLabel("Карта с которой выполняется перевод");
        subText.setBounds(98,94,300,21);
        subText.setFont(Main.font.deriveFont(Font.PLAIN,14));
        add(subText);

        JLabel line1=new JLabel(new ImageIcon("Icons/Vector 3.png"));
        line1.setBounds(145,462,209,2);
        add(line1);


        sumOfTransText=new JLabel("Сумма перевода");
        sumOfTransText.setBounds(188,373,130,21);
        sumOfTransText.setFont(Main.font.deriveFont(Font.PLAIN,14));
        add(sumOfTransText);

        sumOfTransField= new JTextField();
        sumOfTransField.setBounds(151,416,198,38);
        sumOfTransField.setBackground(getBackground());
        sumOfTransField.setBorder(BorderFactory.createEmptyBorder());
        sumOfTransField.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,24));
        sumOfTransField.setHorizontalAlignment(JLabel.CENTER);
        add(sumOfTransField);

        transButton=new Button(21,821,458,80,"Icons/yellowSoftSqare.png");
        transButton.setText("Перевести");
        transButton.setFont(Main.boltFont.deriveFont(Font.PLAIN,20));
        add(transButton);

        transButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sumofTrans=Integer.parseInt(sumOfTransField.getText());
                Main.dbManager.sendMoneyToAnotherCard(Main.cardList.get(cardLabel.currentID),Main.cardList.get(cardLabel2.currentID),sumofTrans);
            }
        });




        backButton=new Button(21,47,33,33,"Icons/icons8-left-arrow-90.png");
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.tranzactionMenu.setVisible(false);
                Main.frame.mainMenu.refreshCardLabel();
            }
        });


    }
}

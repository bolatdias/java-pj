import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMenu extends JDesktopPane implements Runnable {
    private JLabel sumOfTransText;
    private JTextField sumOfTopUp;

    private Button paymentButton;


    private CardLabel cardLabel;


    private Button backButton;




    void refreshCardLabel(){
        cardLabel.changeCard(cardLabel.currentID);
    }

    @Override
    public void run() {
        setSize(500, 960);
        setLayout(null);

        cardLabel = new CardLabel(21, 129);
        add(cardLabel);


        JLabel mainText = new JLabel("Оплатить по коду");
        mainText.setBounds(140, 43, 250, 37);
        mainText.setFont(Main.boltFont.deriveFont(Font.PLAIN, 24));
        add(mainText);


        JLabel subText = new JLabel("Карта с которой будут списаны деньги");
        subText.setBounds(100, 94, 400, 21);
        subText.setFont(Main.font.deriveFont(Font.PLAIN, 14));
        add(subText);

        JLabel line1 = new JLabel(new ImageIcon("Icons/Vector 3.png"));
        line1.setBounds(145, 462, 209, 2);
        add(line1);


        sumOfTransText = new JLabel("Введите код*");
        sumOfTransText.setBounds(188, 373, 130, 21);
        sumOfTransText.setFont(Main.font.deriveFont(Font.PLAIN, 14));
        add(sumOfTransText);

        sumOfTopUp = new JTextField();
        sumOfTopUp.setBounds(151, 416, 198, 38);
        sumOfTopUp.setBackground(getBackground());
        sumOfTopUp.setBorder(BorderFactory.createEmptyBorder());
        sumOfTopUp.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN, 24));
        sumOfTopUp.setHorizontalAlignment(JLabel.CENTER);
        add(sumOfTopUp);

        paymentButton = new Button(87, 528, 325, 54, "Icons/Rectangle 15.png");
        paymentButton.setText("Оплатить");
        paymentButton.setFont(Main.boltFont.deriveFont(Font.PLAIN, 20));
        add(paymentButton);


        backButton = new Button(21, 47, 33, 33, "Icons/icons8-left-arrow-90.png");
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.paymentMenu.setVisible(false);
                Main.frame.mainMenu.refreshCardLabel();
            }
        });



        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card card = Main.cardList.get(cardLabel.currentID);
                if (card.cost() < card.getCurrentMoney()) {
                    Main.cardList.get(cardLabel.currentID).fare(card.cost());
                    paymentButton.setText("");
                    refreshCardLabel();
                } else {
                    System.out.println("Не хватает денег");
                    ;
                }

            }
        });
    }
}

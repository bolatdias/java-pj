import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopUpMenu extends JDesktopPane implements Runnable {
    private JLabel sumOfTransText;
    private JTextField sumOfTopUp;

    private Button topUpButton;


    private CardLabel cardLabel;


    private Button backButton;


    void refreshCardLabel() {
        cardLabel.changeCard(cardLabel.currentID);
    }

    @Override
    public void run() {
        setSize(500, 960);
        setLayout(null);

        cardLabel = new CardLabel(21, 129);
        add(cardLabel);


        JLabel mainText = new JLabel("Пополнить");
        mainText.setBounds(179, 43, 150, 37);
        mainText.setFont(Main.boltFont.deriveFont(Font.PLAIN, 24));
        add(mainText);


        JLabel subText = new JLabel("Выберите карту ONAY! для пополнения");
        subText.setBounds(90, 94, 320, 21);
        subText.setFont(Main.font.deriveFont(Font.PLAIN, 14));
        add(subText);

        JLabel line1 = new JLabel(new ImageIcon("Icons/Vector 3.png"));
        line1.setBounds(145, 462, 209, 2);
        add(line1);


        sumOfTransText = new JLabel("Введите сумму");
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

        topUpButton = new Button(87, 528, 325, 54, "Icons/Rectangle 15.png");
        topUpButton.setText("Пополнить");
        topUpButton.setFont(Main.boltFont.deriveFont(Font.PLAIN, 20));
        add(topUpButton);


        backButton = new Button(21, 47, 33, 33, "Icons/icons8-left-arrow-90.png");
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.topUpMenu.setVisible(false);
                Main.frame.mainMenu.refreshCardLabel();
            }
        });


        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int topUp = Integer.parseInt(sumOfTopUp.getText());
                Main.cardList.get(cardLabel.currentID).addMoney(topUp);
                sumOfTopUp.setText("");
                refreshCardLabel();

            }
        });

    }
}


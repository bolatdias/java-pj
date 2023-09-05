import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JDesktopPane implements Runnable {

    public CardLabel cardLabel;

    private Button addCardButton;
    private Button payBySMSButton;
    private Button translateButton;
    private Button topUpButton;

    private Button exitButton;

    void refreshCardLabel() {
        cardLabel.changeCard(cardLabel.currentID);
    }

    @Override
    public void run() {
        setSize(530, 960);
        setLayout(null);
        setLocation(0, 0);

        cardLabel = new CardLabel(21, 134);


        ImageIcon qrIcon = new ImageIcon("Icons/QRimcage.png");
        ImageIcon transIcon = new ImageIcon("Icons/image 4.png");


        JLabel myCard = new JLabel("МОИ КАРТЫ");
        myCard.setFont(Main.boltFont.deriveFont(Font.PLAIN,16));
        myCard.setBounds(85, 55, 130, 24);
        myCard.setForeground(Color.black);
        add(myCard);

        JLabel myCardLine = new JLabel(new ImageIcon("Icons/YellowLine.png"));
        myCardLine.setBounds(-27, 88, 284, 4);
        add(myCardLine);

        addCardButton = new Button(21, 463, 459, 56, "Icons/addBack.png");
        addCardButton.setText("Открыть новую карту");
        addCardButton.setFont(Main.font.deriveFont(Font.PLAIN,16));
        addCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addCardMenu.setVisible(true);
                Main.frame.mainMenu.setVisible(false);
            }
        });


        payBySMSButton = new Button(190, 570, 120, 120, "Icons/yellowSoftSqure.png");
        payBySMSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.paymentMenu.setVisible(true);
                Main.frame.mainMenu.setVisible(false);
                Main.frame.paymentMenu.refreshCardLabel();
            }
        });
        JLabel qrLabel = new JLabel();
        qrLabel.setBounds(212, 587, 77, 82);
        qrLabel.setIcon(qrIcon);
        add(qrLabel);

        JLabel qrText = new JLabel("Оплатить по коду");
        qrText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        qrText.setBounds(195, 707, 130, 18);
        add(qrText);

        translateButton = new Button(354, 570, 120, 120, "Icons/softWhiteSqare.png");
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.tranzactionMenu.setVisible(true);
                Main.frame.mainMenu.setVisible(false);
                Main.frame.tranzactionMenu.refreshCardLabel();
            }
        });
        JLabel transLabel = new JLabel();
        transLabel.setBounds(366, 589, 95, 76);
        transLabel.setIcon(transIcon);
        add(transLabel);

        JLabel transText = new JLabel("Перевести");
        transText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        transText.setBounds(382, 707, 80, 18);
        add(transText);

        topUpButton = new Button(31, 570, 120, 120, "Icons/topUpicon.png");
        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.topUpMenu.setVisible(true);
                Main.frame.mainMenu.setVisible(false);
                Main.frame.topUpMenu.refreshCardLabel();
            }
        });

        JLabel topUpText = new JLabel("Пополнить");
        topUpText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        topUpText.setBounds(58, 707, 80, 18);
        add(topUpText);


        exitButton = new Button(0, 860, 500, 100, "Icons/exitButton.png");
        exitButton.setText("выход");
        exitButton.setFont(Main.boltFont.deriveFont(Font.PLAIN,24));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.loginAppMenu.setVisible(true);
            }
        });

        add(cardLabel);
        add(addCardButton);
        add(payBySMSButton);
        add(translateButton);
        add(topUpButton);
        add(exitButton);


    }
}

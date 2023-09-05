import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CardLabel extends JDesktopPane {

    private JLabel backGround;

    private JButton preCardButton;
    private JButton nexCardButton;

    public int currentID;
    private JLabel idLabel;
    private JLabel typeOfCardText;
    private JPanel typeOfCardPanel;
    private JLabel cardNameText;
    private JLabel currentMoneyText;
    private TextArea countTravel;


    public CardLabel(int x, int y) {
        setLayout(null);
        setBounds(x, y, 458, 230);


        typeOfCardText = new JLabel();
        typeOfCardText.setBounds(10, 190, 0, 50);
        typeOfCardText.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,24));
        typeOfCardText.setForeground(Color.black);
        add(typeOfCardText);

        setLayer(typeOfCardText, 20);


        typeOfCardPanel = new JPanel();
        typeOfCardPanel.setBounds(0, 0, 0, 50);
        typeOfCardPanel.setBackground(new Color(252, 196, 25));
        add(typeOfCardPanel);


        cardNameText = new JLabel();
        cardNameText.setBounds(75, 23, 150, 29);
        cardNameText.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,19));
        cardNameText.setForeground(Color.black);
        cardNameText.setForeground(Color.BLACK);
        add(cardNameText);


        idLabel = new JLabel();
        idLabel.setBounds(401, 23, 43, 29);
        idLabel.setHorizontalAlignment(JLabel.RIGHT);
        idLabel.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,19));
        idLabel.setForeground(Color.black);
        idLabel.setForeground(Color.BLACK);
        add(idLabel);


        currentMoneyText = new JLabel();
        currentMoneyText.setBounds(75, 140, 190, 50);
        currentMoneyText.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,35));
        currentMoneyText.setForeground(Color.BLACK);
        add(currentMoneyText);


        preCardButton = new Button(373, 153, 37, 37, "Icons/prevIcon.png");
        add(preCardButton);
        preCardButton.setBackground(new Color(255, 255, 255, 0));
        preCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentID > 0) {
                    changeCard(currentID - 1);
                    System.out.println(currentID);
                }
            }
        });
        preCardButton.setBorder(BorderFactory.createEmptyBorder());

        setLayer(preCardButton, 50);


        nexCardButton = new Button(407, 153, 37, 37, "Icons/nextIcon.png");
        add(nexCardButton);
        nexCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentID < Main.cardList.size() - 1) {
                    changeCard(currentID + 1);
                    System.out.println(currentID);
                }
            }
        });
        nexCardButton.setBackground(new Color(255, 255, 255, 0));
        nexCardButton.setBorder(BorderFactory.createEmptyBorder());

        setLayer(nexCardButton, 50);

        backGround = new JLabel();
        backGround.setBounds(0, 0, 458, 230);
        add(backGround);
    }


    void changeCard(int i) {
        if (Main.cardList.size() > 0) {
            currentID = i;

            switch (Main.cardList.get(i).getTypeOfCard()) {
                case "STUDENT":
                    ImageIcon imageIcon = new ImageIcon("Icons/СтуденсческаяКарта.png");
                    backGround.setIcon(imageIcon);
                    break;
                case "PENSIONERS":
                    ImageIcon imageIcon2 = new ImageIcon("Icons/PenCard.png");
                    backGround.setIcon(imageIcon2);
                    break;
                case "DEFAULT":
                    ImageIcon imageIcon3 = new ImageIcon("Icons/ЕдинаяКарта.png");
                    backGround.setIcon(imageIcon3);
                    break;
            }

            idLabel.setText(Integer.toString(Main.cardList.get(i).getId()));
            cardNameText.setText(Main.cardList.get(i).getName());
            currentMoneyText.setText(Integer.toString(Main.cardList.get(i).getCurrentMoney()) + ".00 T");


        }
    }

}

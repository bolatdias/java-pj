import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.*;

public class AddCardMenu extends JDesktopPane implements Runnable{

    private JTextField idField;

    private JButton addButton;
    private JButton backButton;

    private JLabel errorText;




    @Override
    public void run() {
        setSize(500, 960);
        setLayout(null);


        JLabel mainText=new JLabel("Добавить карту");
        mainText.setBounds(140,43,220,37);
        mainText.setFont(Main.boltFont.deriveFont(Font.PLAIN,24));
        add(mainText);


        JLabel subText=new JLabel("Введите ИД карты");
        subText.setBounds(188,310,150,21);
        subText.setFont(Main.font.deriveFont(Font.PLAIN,14));
        add(subText);

        JLabel line1=new JLabel(new ImageIcon("Icons/Vector 3.png"));
        line1.setBounds(145,399,209,2);
        add(line1);


        idField= new JTextField();
        idField.setBounds(157,346,198,38);
        idField.setBackground(getBackground());
        idField.setBorder(BorderFactory.createEmptyBorder());
        idField.setFont(Main.extraBoltFont.deriveFont(Font.PLAIN,24));
        idField.setHorizontalAlignment(JLabel.CENTER);
        add(idField);

        addButton=new Button(87,569,325,54,"Icons/Rectangle 15.png");
        addButton.setText("Добавить");
        addButton.setFont(Main.boltFont.deriveFont(Font.PLAIN,20));
        add(addButton);


        errorText=new JLabel( );
        errorText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        errorText.setForeground(Color.red);
        errorText.setBounds(192,425,400,42);
        add(errorText);



        backButton=new Button(21,47,33,33,"Icons/icons8-left-arrow-90.png");
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.addCardMenu.setVisible(false);
                Main.frame.mainMenu.refreshCardLabel();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(idField.getText());
                if(checkCardInCardList(id)) {
                    Main.dbManager.addCard(new Card(id));
                    Main.cardList = Main.dbManager.getCardListFromDB();
                    idField.setText("");
                    errorText.setText("");
                }
                else{
                    errorText.setText("Такая карта уже есть");
                }
            }
        });

    }

    private boolean checkCardInCardList(int id){

        for(int i=0;i<Main.cardList.size();i++){
            if(Main.cardList.get(i).getId()==id){
                return false;
            };
        }
        return true;
    }
}

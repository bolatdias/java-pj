import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.MissingFormatArgumentException;

public class LoginAppMenu extends JDesktopPane implements Runnable {
    private JLabel onayIcon;
    private JLabel enterText;
    private JLabel descriptionText;

    private JLabel errorText;
    private Button loginInButtton;
    private Button registerButton;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;


    @Override
    public void run() {
        setSize(500,960);
        setLayout(null);
        setBackground(new Color(251,218,0));

        onayIcon=new JLabel(new ImageIcon("Icons/onayIcon.png"));
        onayIcon.setBounds(41,53,184,56);
        add(onayIcon);

        enterText=new JLabel("Вход");
        enterText.setFont(Main.extraBoltFont.deriveFont(Font.BOLD,40));
        enterText.setForeground(Color.BLACK);
        enterText.setBounds(50,126,140,61);
        add(enterText);

        descriptionText=new JLabel("Введите ваш номер и пароль, указанные при регистрации ");
        descriptionText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        descriptionText.setForeground(new Color(0,0,0,90));
        descriptionText.setBounds(52,204,400,42);
        add(descriptionText);


        errorText=new JLabel( );
        errorText.setFont(Main.font.deriveFont(Font.PLAIN,12));
        errorText.setForeground(Color.red);
        errorText.setBounds(52,435,400,42);
        add(errorText);

        usernameLabel=new JLabel(new ImageIcon("Icons/usernameIcon.png"));
        usernameLabel.setBounds(12,293,38,33);
        add(usernameLabel);


        JLabel line1=new JLabel(new ImageIcon("Icons/Vector 1.png"));
        line1.setBounds(65,323,421,2);
        add(line1);

        usernameField=new JTextField();
        usernameField.setBounds(63,287,419,27);
        usernameField.setBackground(getBackground());
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.setFont(Main.font.deriveFont(Font.PLAIN,18));


        JLabel line2=new JLabel(new ImageIcon("Icons/Vector 1.png"));
        line2.setBounds(65,425,421,2);
        add(line2);

        add(usernameField);


        passwordLabel=new JLabel(new ImageIcon("Icons/passwordIcon.png"));
        passwordLabel.setBounds(12,381,46,52);
        add(passwordLabel);

        passwordField=new JTextField();
        passwordField.setBounds(63,391,419,27);
        passwordField.setBackground(getBackground());
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setFont(Main.font.deriveFont(Font.PLAIN,18));
        add(passwordField);

        loginInButtton=new Button(323,474,159,47,"Icons/loginButton.png");
        loginInButtton.setText("войти");
        loginInButtton.setFont(Main.boltFont.deriveFont(Font.PLAIN,14));
        loginInButtton.setForeground(Color.BLACK);
        loginInButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.dbManager.checkUserPass(new User(usernameField.getText(),passwordField.getText()))) {
                    Main.cardList=Main.dbManager.getCardListFromDB();
                    Main.frame.loginAppMenu.setVisible(false);
                    Main.frame.mainMenu.setVisible(true);
                    Main.frame.mainMenu.refreshCardLabel();

                    passwordField.setText("");
                    usernameField.setText("");
                    errorText.setText("");
                }
                else {
                    errorText.setText("Неправильный пароль или логин!!");
                }
            }
        });
        add(loginInButtton);

        registerButton=new Button(12,834,476,76,"Icons/registerButton.png");
        registerButton.setText("РЕГИСТРАЦИЯ");
        registerButton.setFont(Main.boltFont.deriveFont(Font.PLAIN,14));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.registerMenu.setVisible(true);
                Main.frame.loginAppMenu.setVisible(false);
            }
        });
        add(registerButton);
    }
}

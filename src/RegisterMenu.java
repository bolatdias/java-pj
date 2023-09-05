import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterMenu extends JDesktopPane implements Runnable{
    private JLabel enterText;
    private JLabel descriptionText;

    private Button loginInButtton;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JTextField passwordField;


    @Override
    public void run() {
        setSize(500,960);
        setLayout(null);
        setBackground(new Color(251,218,0));


        enterText=new JLabel("Добро");
        enterText.setFont(Main.extraBoltFont.deriveFont(Font.BOLD,40));
        enterText.setForeground(Color.BLACK);
        enterText.setBounds(50,76,180,61);
        add(enterText);

        JLabel enterText2=new JLabel("пожаловать!");
        enterText2.setFont(Main.extraBoltFont.deriveFont(Font.BOLD,40));
        enterText2.setForeground(Color.BLACK);
        enterText2.setBounds(50,126,400,61);
        add(enterText2);

        descriptionText=new JLabel("Введите номер вашего телефона");
        descriptionText.setFont(Main.font.deriveFont(Font.PLAIN,16));
        descriptionText.setForeground(new Color(0,0,0,90));
        descriptionText.setBounds(52,184,400,42);
        add(descriptionText);

        usernameLabel=new JLabel(new ImageIcon("Icons/usernameIcon.png"));
        usernameLabel.setBounds(12,243,38,33);
        add(usernameLabel);


        JLabel line1=new JLabel(new ImageIcon("Icons/Vector 1.png"));
        line1.setBounds(65,273,421,2);
        add(line1);

        usernameField=new JTextField();
        usernameField.setBounds(63,237,419,27);
        usernameField.setBackground(getBackground());
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.setFont(Main.font.deriveFont(Font.PLAIN,18));


        JLabel line2=new JLabel(new ImageIcon("Icons/Vector 1.png"));
        line2.setBounds(65,375,421,2);
        add(line2);

        add(usernameField);



        passwordLabel=new JLabel(new ImageIcon("Icons/passwordIcon.png"));
        passwordLabel.setBounds(12,331,46,52);
        add(passwordLabel);

        passwordField=new JTextField();
        passwordField.setBounds(63,341,419,27);
        passwordField.setBackground(getBackground());
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setFont(Main.font.deriveFont(Font.PLAIN,18));
        add(passwordField);

        loginInButtton=new Button(323,424,159,47,"Icons/loginButton.png");
        loginInButtton.setText("создать");
        loginInButtton.setFont(Main.boltFont.deriveFont(Font.PLAIN,14));
        loginInButtton.setForeground(Color.BLACK);
        loginInButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.registerMenu.setVisible(false);
                Main.frame.loginAppMenu.setVisible(true);
                Main.dbManager.addUser(new User(usernameField.getText(),passwordField.getText()));
            }
        });
        add(loginInButtton);

    }
}


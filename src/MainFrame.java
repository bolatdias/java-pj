import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainMenu mainMenu;

    public LoginAppMenu loginAppMenu;
    public RegisterMenu registerMenu;
    public PaymentMenu paymentMenu;
    public TranzactionMenu tranzactionMenu;
    public TopUpMenu topUpMenu;
    public AddCardMenu addCardMenu;
    public MainFrame() {
        setSize(515,985);
        setLocation(0,0);
        setFocusable(false);
        setIconImage(new ImageIcon("Icons/icon.png").getImage());
        setTitle("ONAY");


        loginAppMenu=new LoginAppMenu();
        Thread thread=new Thread(loginAppMenu);
        thread.start();
        add(loginAppMenu);
        loginAppMenu.setVisible(true);

        mainMenu=new MainMenu();
        Thread thread2=new Thread(mainMenu);
        thread2.start();
        add(mainMenu);
        mainMenu.setVisible(false);

        registerMenu=new RegisterMenu();
        Thread thread3=new Thread(registerMenu);
        thread3.start();
        add(registerMenu);
        registerMenu.setVisible(false);



        paymentMenu=new PaymentMenu();
        Thread thread4=new Thread(paymentMenu);
        thread4.start();
        add(paymentMenu);
        paymentMenu.setVisible(false);

        tranzactionMenu=new TranzactionMenu();
        Thread thread5=new Thread(tranzactionMenu);
        thread5.start();
        add(tranzactionMenu);
        tranzactionMenu.setVisible(false);

        topUpMenu=new TopUpMenu();
        Thread thread6=new Thread(topUpMenu);
        thread6.start();
        add(topUpMenu);
        topUpMenu.setVisible(false);

        addCardMenu=new AddCardMenu();
        Thread thread7=new Thread(addCardMenu);
        thread7.start();
        add(addCardMenu);
        addCardMenu.setVisible(false);
    }
}

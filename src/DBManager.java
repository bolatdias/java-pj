import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public Connection connection;

    public DBManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:8888/" + "onay", "postgres", "2004");
            CreateTableOnDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CreateTableOnDB(){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "CREATE TABLE IF NOT EXISTS public.cards\n" +
                    "(\n" +
                    "    id serial PRIMARY KEY,\n" +
                    "    card_name character varying NOT NULL,\n" +
                    "    current_money integer,\n" +
                    "    typeofcard character varying NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS public.users\n" +
                    "(\n" +
                    "    id serial PRIMARY KEY,\n" +
                    "    username character varying NOT NULL,\n" +
                    "    password character varying NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS public.user_card\n" +
                    "(\n" +
                    "    id serial PRIMARY KEY,\n" +
                    "    user_id integer,\n" +
                    "    card_id integer,\n" +
                    "    CONSTRAINT user_card_card_id_fkey FOREIGN KEY (card_id)\n" +
                    "        REFERENCES public.cards (id) ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                    "    CONSTRAINT user_card_user_id_fkey FOREIGN KEY (user_id)\n" +
                    "        REFERENCES public.users (id) ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                    ");");

            int rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (username,password)" +
                    "VALUES (?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void addCard(Card card) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO user_card (user_id,card_id)" +
                    "VALUES (?,?)");
            statement.setInt(1, MyUser.getId());
            statement.setInt(2, card.getId());

            int rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Card> getCardListFromDB() {
        ArrayList<Card> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT cards.id, card_name, current_money, typeofcard FROM user_card,cards WHERE user_id=? and user_card.card_id=cards.id");
            statement.setInt(1,MyUser.getId());

            ResultSet resultSet = statement.executeQuery(); //SELECT

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("card_name");
                int money = resultSet.getInt("current_money");
                String typeOfCard = resultSet.getString("typeofcard");
                arrayList.add(new Card(id, money, name, typeOfCard));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }


    public void sendMoneyToAnotherCard(Card card1, Card card2, int money) {
        if (money <= card1.getCurrentMoney()) {
            card1.fare(money);
            card2.addMoney(money);
            Main.frame.tranzactionMenu.refreshCardLabel();
        }
    }

    public boolean checkUserPass(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE username=? AND password=?");
            statement.setString(1, user.getUsername());
            statement.setString(2,user.getPassword());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                // set User///
                MyUser.setId(resultSet.getInt("id"));
                MyUser.setUsername(resultSet.getString("username"));
                MyUser.setPassword(resultSet.getString("password"));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
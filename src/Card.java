import java.sql.PreparedStatement;

public class Card {
    private int id;
    private String name;
    private int currentMoney;
    private String typeOfCard;

    public Card(int id) {
        this.id = id;
    }
    public Card(int id, String name, String typeOfCard) {
        this.id = id;
        this.name = name;
        this.typeOfCard = typeOfCard;
    }
    public Card(int id,int currentMoney, String name, String typeOfCard) {
        this.id = id;
        this.name = name;
        this.currentMoney = currentMoney;
        this.typeOfCard = typeOfCard;
}

     void addMoney(int money) {
         try {
             PreparedStatement statement = Main.dbManager.connection.prepareStatement("UPDATE cards SET current_money=? WHERE id=?");
             statement.setInt(1, currentMoney + money);
             statement.setInt(2, id);
             currentMoney+=money;

             int rows=statement.executeUpdate();
             statement.close();
         }
         catch (Exception e) {
             e.printStackTrace();
         }
     }

    public int cost(){
        switch (typeOfCard){
            case "DEFAULT":
                return 80;
            default:
                return 40;
        }
    }

    public void fare(int money) {
        try {
            PreparedStatement statement = Main.dbManager.connection.prepareStatement("UPDATE cards SET current_money=? WHERE id=?");
            statement.setInt(1, currentMoney - money);
            statement.setInt(2, id);
            currentMoney-=money;

            int rows=statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }



    public int getCurrentMoney() {
        return currentMoney;
    }


    public String getTypeOfCard() {
        return typeOfCard;
    }

}

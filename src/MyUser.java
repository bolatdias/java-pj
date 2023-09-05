public class MyUser {
    private static int id;
    private static String username;
    private static String password;

    public MyUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public MyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MyUser.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyUser.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MyUser.password = password;
    }
}
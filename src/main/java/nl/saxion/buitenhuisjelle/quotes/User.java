package nl.saxion.buitenhuisjelle.quotes;

public class User {

    private int id;
    private static int LAST_ID = 0;

    private String name;
    private String password;

    public User(String name, String password) {
        this.id = LAST_ID;
        LAST_ID++;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String toString()
    {
     return "User: " + id + " name: " + name + " password " + password;
    }

}

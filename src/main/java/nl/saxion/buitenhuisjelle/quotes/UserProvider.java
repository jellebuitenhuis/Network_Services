package nl.saxion.buitenhuisjelle.quotes;

import java.util.ArrayList;

public class UserProvider {

    private ArrayList<User> users;

    public UserProvider() {
        users = new ArrayList<>();

        users.add(new User("Jelle", "123"));
        users.add(new User("Jantje", "Length is better than complexity"));
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

}

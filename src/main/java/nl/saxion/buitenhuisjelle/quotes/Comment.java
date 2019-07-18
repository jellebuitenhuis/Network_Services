package nl.saxion.buitenhuisjelle.quotes;

public class Comment {

    private int id;
    private static int LAST_ID = 0;

    private String user;
    private String text;

    public Comment(String user, String text) {
        this.id=LAST_ID;
        LAST_ID++;
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public String toString()
    {
        return "Comment: " + id + " user:  " + user +  " text: " + text;
    }

}

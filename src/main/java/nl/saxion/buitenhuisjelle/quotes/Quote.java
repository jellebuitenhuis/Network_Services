package nl.saxion.buitenhuisjelle.quotes;

import java.util.ArrayList;

public class Quote {

    private int id;
    private static int LAST_ID = 0;
    private ArrayList<Comment> comments;
    private ArrayList<String> likes;

    private String user;
    private String name;
    private String text;

    public Quote(String user, String name, String text)
    {
        this.id = LAST_ID;
        LAST_ID++;
        this.user = user;
        this.name = name;
        this.text = text;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    public void addLike(String username)
    {
        likes.add(username);
    }

    public int getCommentAmount()
    {
        return comments.size();
    }

    public int getLikeAmount()
    {
        return likes.size();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getLikes()
    {
        return likes;
    }

    public ArrayList<Comment> getComments()
    {
        return comments;
    }

    public int getId()
    {
        return id;
    }

    public String toString()
    {
        return "Quote " + id + " sender: " + user + " name: " + name + " text: " + text;
    }
}

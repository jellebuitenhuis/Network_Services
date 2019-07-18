package nl.saxion.buitenhuisjelle.quotes;

import java.util.ArrayList;

public class QuotesProvider {

    private ArrayList<Quote> quotes;

    public QuotesProvider() {
        quotes = new ArrayList<>();
    }

    public void addComment(Comment comment, int id)
    {
        for(Quote quote : quotes)
        {
            if(quote.getId() == id)
            {
                quote.addComment(comment);
                return;
            }
        }
    }

    public ArrayList<Comment> getComments(int id)
    {
        for(Quote quote : quotes)
        {
            if(quote.getId() == id)
            {
                 return quote.getComments();
            }
        }
        return null;
    }

    public ArrayList<Quote> searchQuotes(String text)
    {
        ArrayList<Quote> returnQuotes = new ArrayList<>();
        for(Quote quote : quotes)
        {
            if(quote.getText().contains(text))
            {
                returnQuotes.add(quote);
            }
        }
        return returnQuotes;
    }

    public Quote getQuote(int id)
    {
        for (Quote quote : quotes) {
            if(quote.getId() == id)
            {
                return quote;
            }
        }
        return null;
    }

    public void likeQuote(String username, int id)
    {
        for(Quote quote : quotes)
        {
            if(quote.getId() == id)
            {
                for(String u : quote.getLikes())
                {
                    if(u.equals(username)) {
                        return;
                    }
                }
                quote.addLike(username);
            }
        }
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void addQuote(Quote quote)
    {
        quotes.add(quote);
    }

}

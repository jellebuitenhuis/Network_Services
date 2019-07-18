package nl.saxion.buitenhuisjelle.quotes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/quotes")
public class QuotesController {

    private QuotesProvider qp = new QuotesProvider();

    @GetMapping("")
    public String getQuotes(Model model, HttpSession session)
    {
        model.addAttribute("newquote", new Quote("", "", ""));
        model.addAttribute("quotes", qp.getQuotes());
        if(session.getAttribute("username") != null)
        {
            model.addAttribute("sessionCheck", session);
            return "quotes";
        }
        return "loginerror";
    }

    @GetMapping("/search")
    public String searchQuotes(@RequestParam("search") String text, Model model)
    {
        model.addAttribute("newquote", new Quote("", "", ""));
        model.addAttribute("quotes",qp.searchQuotes(text));
        return "quotes";
    }

    @PostMapping("/{id}/like")
    public String addLike(@PathVariable("id") int id, HttpSession session, Model model)
    {
        if(session.getAttribute("username") != null)
        {
            model.addAttribute("newquote", new Quote("", "", ""));
            model.addAttribute("quotes", qp.getQuotes());
            qp.likeQuote(session.getAttribute("username").toString(),id);
            return "redirect:/quotes";
        }
        return "loginerror";

    }

    @PostMapping("/{id}")
    public String addComment(@PathVariable("id") int id, @ModelAttribute Comment comment, Model model, HttpSession session)
    {
        if(qp.getComments(id) != null) {
            model.addAttribute("newcomment", new Comment("", ""));
            model.addAttribute("quote", qp.getQuote(id));
            model.addAttribute("comments", qp.getComments(id));
            comment.setUser(session.getAttribute("username").toString());
            qp.addComment(comment, id);
            return "comments";
        }
        return "error";

    }

    @GetMapping("/{id}")
    public String getComments( Model model, @PathVariable("id") int id)
    {
        if(qp.getComments(id) != null)
        {
            model.addAttribute("newcomment", new Comment("", ""));
            model.addAttribute("quote",qp.getQuote(id));
            model.addAttribute("comments", qp.getComments(id));
            return "comments";
        }
        return "error";
    }

    @PostMapping("")
    public String postQuote ( @ModelAttribute Quote quote, Model model, HttpSession session)
    {
        model.addAttribute("newquote", new Quote("", "", ""));
        model.addAttribute("quotes", qp.getQuotes());
        model.addAttribute("sessionCheck", session);
        quote.setUser(session.getAttribute("username").toString());
        qp.addQuote(quote);
        return "quotes";
    }

}

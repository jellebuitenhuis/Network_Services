package nl.saxion.buitenhuisjelle.quotes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    UserProvider up = new UserProvider();

    @GetMapping("")
    public String addUserForm(Model model)
    {
        model.addAttribute("user",new User("",""));
        return "users";
    }

    @PostMapping("")
    public String addUser (@CookieValue(value = "GDPR",defaultValue = "0") int gdpr, @ModelAttribute User user, Model model, HttpSession session)
    {
        up.addUser(user);
        Cookie cookie = new Cookie("GDPR", "" + gdpr);
        model.addAttribute("gdprCookie",cookie);
        model.addAttribute("sessionCheck",session);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session)
    {
        model.addAttribute("user",new User("",""));
        if(session.getAttribute("username") != null)
        {
            return "redirect:/quotes";
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser ( @ModelAttribute User logInUser, Model model, HttpSession session)
    {
        model.addAttribute("user",new User("",""));
        for(User user : up.getUsers())
        {
            if(user.getName().equals(logInUser.getName()))
            {
                if(user.getPassword().equals(logInUser.getPassword()))
                {
                    session.setAttribute("username",logInUser.getName());
                    return "redirect:/";
                }
            }
        }
        return "wrongcreds";
    }

}

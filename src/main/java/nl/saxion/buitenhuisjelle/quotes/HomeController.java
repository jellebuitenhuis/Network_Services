package nl.saxion.buitenhuisjelle.quotes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {


    @GetMapping("")
    public String getHome(HttpServletResponse response,@CookieValue(value = "GDPR",defaultValue = "0") int gdpr, Model model, HttpSession session) {
        Cookie cookie = new Cookie("GDPR", "" + gdpr);
        model.addAttribute("gdprCookie",cookie);
        model.addAttribute("sessionCheck",session);
        cookie.setMaxAge(1000);
        response.addCookie(cookie);
        return "home";
    }

    @PostMapping("")
    public String acceptGDPR(HttpServletResponse response, Model model, HttpSession session) {
        Cookie cookie = new Cookie("GDPR", "1");
        model.addAttribute("gdprCookie",cookie);
        model.addAttribute("sessionCheck",session);
        response.addCookie(cookie);
        return "home";
    }
}

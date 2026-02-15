package jobsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Legacy controller kept for reference.
 *
 * Mapped under /legacy to avoid clashing with the main HomeController.
 */
@Controller("legacyHomeController")
@RequestMapping("/legacy")
public class HomeController {

    @GetMapping({"", "/"})
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

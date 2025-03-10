package jobsite.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }


    @RequestMapping(value = "my/{id}")
    public String my(Model model, @PathVariable("id") Integer id,
                     HttpServletResponse resp) throws IOException {
        System.out.println("id = " + id);
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        for (int i = 1; i <= id; ++i) {
            sb.append("<tr>");
            for (int j = 1; j <= id; ++j) {
                sb.append("<td>");
                sb.append(i * j);
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");

        PrintWriter out = resp.getWriter();
        //out.write(sb.toString());
        out.write("<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
        out.write("</head>\n");
        out.write("<body>Текст в кодировке UTF-8</body>");

        return null;
        //model.addAttribute("message", "<b>" + id * id + "</b>");
        //model.addAttribute("id", id);
        //return "home/my";
    }
}
package jobsite.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home/home";
    }
}

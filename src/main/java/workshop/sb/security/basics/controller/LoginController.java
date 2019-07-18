package workshop.sb.security.basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//    TODO 1 - utwórz kontroller: przekierowanie z GET, "/login" do strony login.html
@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}

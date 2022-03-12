package haulmontTest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String base() {
        return "redirect:index";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}

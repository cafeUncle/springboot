package yangy_coder.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("helloText", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        return "hello";
    }

}
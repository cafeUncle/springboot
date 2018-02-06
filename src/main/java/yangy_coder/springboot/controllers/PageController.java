package yangy_coder.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("helloText", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        return "hello";
    }

    @RequestMapping("/willError")
    public String willError(Model model) {
        Collections.emptyList().get(3);
        return "hello";
    }

}
package yangy_coder.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yangy_coder.springboot.properties.AutoWireDemo;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
public class PageController {

    protected static Logger logger=LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("helloText", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        logger.debug("这是一个根路径的日志{}{}","111","222");
        return "hello";
    }

    @RequestMapping("/willError")
    public String willError(Model model) {
        Collections.emptyList().get(3);
        return "hello";
    }

    @RequestMapping("/webSocket")
    public String webSocket(Model model) {
        return "webSocket";
    }

    @RequestMapping("/multiDB")
    public String multiDB(){
        return "db";
    }

}
package yangy_coder.springboot.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class DateController {

    @GetMapping("/hello")
    public Date hello() {
        return new Date();
    }

}

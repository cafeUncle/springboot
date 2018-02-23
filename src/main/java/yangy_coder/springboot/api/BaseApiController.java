package yangy_coder.springboot.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yangy_coder.springboot.controllers.PageController;

@RestController("/api")
public class BaseApiController {
    protected Logger logger=LoggerFactory.getLogger(this.getClass());
}

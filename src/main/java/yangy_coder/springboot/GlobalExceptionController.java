package yangy_coder.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// 这里使用Advice的注解就不需要让其他controller继承了
@ControllerAdvice
public class ExceptionController {
    @Value("${error.url}")
    private String errUrl;

    @ExceptionHandler(value = Exception.class)
    public String errorHandler(HttpServletRequest request, Exception e, Model model){
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("exception", e);
        return errUrl;
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    @ResponseBody
    public String unsupportedOperationException(HttpServletRequest request, Exception e, Model model){
        return "UnsupportedOperationException";
    }
}

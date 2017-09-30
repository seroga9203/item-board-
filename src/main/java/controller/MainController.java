package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MainControllerService;
import spring.SpringContextHolder;

@Controller
public class MainController {

    @RequestMapping("/main.html")    
    private ModelAndView controlMain(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("exit") != null){
            req.getSession().removeAttribute("login");
        }
        MainControllerService mcs = (MainControllerService) SpringContextHolder.getContext().getBean("mainservice");
        return mcs.controlMainService(req);
    }

}

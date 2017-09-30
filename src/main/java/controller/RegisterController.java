package controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import objectEntity.UserObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserControllerService;


@Controller
public class RegisterController {
    @RequestMapping("/register.html")
    public ModelAndView register(HttpServletRequest req){
        ModelAndView mv;
        
        String pass = req.getParameter("pass");
        String checkPass = req.getParameter("checkPass");
        String login = req.getParameter("login");
        Date date = new Date();
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String city = req.getParameter("city");
  
        UserControllerService us = new UserControllerService();
        UserObject uo = us.registerUser(login, pass, checkPass, date, phone, email, city);
        
        //переходы
        if (uo.isIsChecked() ==true) {
            //передаем в БД
            uo.setUser();
            req.getSession().setAttribute("login", login);
            //переводим на мейн
            mv = new ModelAndView("main");
        } else {
            mv = new ModelAndView("register", "user", uo.getUserList());
           
        }

        return mv;
          
      }
    
}

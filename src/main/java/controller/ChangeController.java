
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objectEntity.UserObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserControllerService;

@Controller
public class ChangeController {
     @RequestMapping("/change.html")
     public ModelAndView autentificate(HttpServletRequest req) { 
        ModelAndView mv;
        HttpSession session = req.getSession();
        
        String currLogin = (String) session .getAttribute("login"); //получаем логин залогиненого юзера
        String currPass = req.getParameter("currPass");
        String pass = req.getParameter("pass");
        String checkPass = req.getParameter("checkPass");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String city = req.getParameter("city");
        
        UserControllerService us = new UserControllerService();
         UserObject uo = us.changeUser(currLogin, currPass, pass, checkPass, phone, email, city);
               //переходы
        if (uo.isIsChecked()) {
       
            //передаем в БД изменения
            uo.updateUser();
            
            //переводим на мейн
            mv = new ModelAndView("main");
        } else {
            mv = new ModelAndView("change", "user", uo.getUserList());
             
        }
        return mv;
     
     }
}

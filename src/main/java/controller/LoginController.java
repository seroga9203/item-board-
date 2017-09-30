package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objectEntity.UserObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserControllerService;

@Controller
public class LoginController {

    @RequestMapping("/login.html")
    public ModelAndView autentificate(HttpServletRequest req) {
        HttpSession s = req.getSession();
        ModelAndView mv;
        UserControllerService us = new UserControllerService();
        String pass = req.getParameter("pass");
        String login = req.getParameter("login");
        UserObject uo = us.checkUserPassw(login, pass);

        if (uo.isIsChecked() == true) {
            //если все корректно - на страницу мейн с засечиванием аттрибутов сессии
            s.setAttribute("login", uo.getLogin());
            s.setAttribute("pass", uo.getPassword());
            mv = new ModelAndView("main");
        } else {

            //если нет пользователя по логину - проставляем в сессию атрибут логин еррор, который будут отображен на странице
            mv = new ModelAndView("login", "user", uo.getUserList());
        }

        return mv;
    }
}

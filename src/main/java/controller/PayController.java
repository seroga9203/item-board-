package controller;

import entity.Item;
import hibernate.HibernateUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.Date;
import service.PayControllerService;

@Controller
public class PayController {


    @RequestMapping("/pay.html")
    public ModelAndView controlPay(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String id = req.getParameter("id");//получение ид нашего товара     
        PayControllerService pcs = new PayControllerService();//инициализация сервиса обработки данных
        String isTop = req.getParameter("isTop");//
        String dt = req.getParameter("Date");

        return pcs.payControllerService(req, id, isTop, dt);
    }
}

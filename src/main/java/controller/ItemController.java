package controller;

import dao.ItemDAO;
import entity.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.SpringContextHolder;

@Controller

public class ItemController {

    @RequestMapping("/item.html")
    public ModelAndView item(HttpServletRequest req) {
        String str = req.getParameter("id");
        int id = Integer.parseInt(str);
        System.out.println("ID: " + id);
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        Item items = idao.getItemById(id);
        ModelAndView mw = new ModelAndView("item", "displayitem", items);;
        return mw;
    }
}

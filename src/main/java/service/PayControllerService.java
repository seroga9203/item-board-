package service;

import dao.ItemDAO;
import entity.Item;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import spring.SpringContextHolder;

public class PayControllerService {

    public ModelAndView payControllerService(HttpServletRequest req, String id, String isTop, String dt) {
        ModelAndView mw;
        int ids = Integer.parseInt(id);
        Item i;
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");// = idao.getItemById(ids);//инициализация дао ???
        i = idao.getItemById(ids);//достаем итем
        //подымаем или опускаем в топе
        mw = new ModelAndView("pay", "id", ids);
        if (id != null && isTop != null) {
            // если закоментировать то бильдиться =)
            if (i.isIsTop()==1) {
                i.setIsTop(0);
            } else {
                i.setIsTop(1);
            }
            idao.updateItem(i);//апдейт товара
            TopItemListRandomizer listRandom = (TopItemListRandomizer) SpringContextHolder.getContext().getBean("randomlist");
            List<Item> topItems = listRandom.getRandomTopItems();
            List<Item> items = idao.get();
            mw = new ModelAndView("redirect:main.html", "displayitem", items);

            return mw;
        }
        if (id != null && dt != null) {
            i.setDate(new Date());
            idao.updateItem(i);
            TopItemListRandomizer listRandom = (TopItemListRandomizer) SpringContextHolder.getContext().getBean("randomlist");
            List<Item> topItems = listRandom.getRandomTopItems();
            List<Item> items = idao.get();
            mw = new ModelAndView("redirect:main.html", "displayitem", items);
            
        }

        return mw;
    }

   
    
}

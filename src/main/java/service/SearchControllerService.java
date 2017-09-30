package service;

import dao.ItemDAO;
import entity.Item;
import org.springframework.web.servlet.ModelAndView;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchControllerService {

    public ModelAndView controlSearchService(HttpServletRequest req) {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> items;
        ModelAndView mw;
        String category = req.getParameter("categories");
        String searchWord = req.getParameter("searchword").trim();
        TopItemListRandomizer listRandom = (TopItemListRandomizer) SpringContextHolder.getContext().getBean("randomlist");
        List<Item> topItems = listRandom.getRandomTopItems();


        if (searchWord.isEmpty() && category.equals("all")) {
            items = idao.get();
        } else if (searchWord.isEmpty() && !category.equals("all")) {
            items = idao.getItemByCategory(category);
        } else if (!searchWord.isEmpty() && category.equals("all")) {
            items = idao.getItemByName(searchWord);
        } else {
            items = idao.getItemByCategoryAndName(category, searchWord);
        }


        if(!items.isEmpty()){
        mw = new ModelAndView("main", "displayitem", items);
        } else {
            mw = new ModelAndView("main", "errorSearch", "Sorry! Try something else!");
        }
        if (topItems !=null) {
            mw.addObject("topItems", topItems);
        }
        return mw;
    }
}

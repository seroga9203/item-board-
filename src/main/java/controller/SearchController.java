package controller;

import dao.ItemDAO;
import entity.Item;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SearchControllerService;
import spring.SpringContextHolder;

@Controller
public class SearchController {

    @RequestMapping("/search.html")
    public ModelAndView controlSearch(HttpServletRequest req) {
        SearchControllerService scs = (SearchControllerService) SpringContextHolder.getContext().getBean("searchservice");
        return scs.controlSearchService(req);
    }
}

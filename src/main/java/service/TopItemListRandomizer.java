package service;

import dao.ItemDAO;
import entity.Item;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import spring.SpringContextHolder;

public class TopItemListRandomizer {

    public List<Item> getRandomTopItems() {
        ItemDAO idao = (ItemDAO) SpringContextHolder.getContext().getBean("idao");
        List<Item> list = idao.getItemByIsTop();
        List<Item> topList = null;

        if (list != null) {
            topList = new LinkedList<>(list);
            Collections.shuffle(topList,new Random());
        }
        List<Item> out = new LinkedList<>();
        for(int i = 0; i < 3; i++){
            if(topList.size()>i){
                out.add(topList.get(i));
            }else{
                break;
            }
        }

        return out;
    }

}

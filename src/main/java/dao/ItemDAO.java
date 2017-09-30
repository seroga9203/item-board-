package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ItemDAO {

    public List<Item> get() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Item> out = s.createQuery("FROM Item").list();
        s.getTransaction().commit();
        s.close();
        return out;
    }

    public Item getItemById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Item out = (Item) s.createQuery("FROM Item WHERE id=" + id).uniqueResult();
        s.getTransaction().commit();
        s.close();
        return out;
    }

    public List<Item> getItemByCategoryAndName(String category, String name) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Item> out;
        if (category.equals("all")) {
            Query q = s.createQuery("FROM Item ");
            out = q.list();
        } else {
            Query q = s.createQuery("FROM Item where cat= :category and name like :name");
            q.setParameter("category", category);
            q.setParameter("name", "%" + name + "%");
            out = q.list();
        }

        s.getTransaction().commit();
        s.close();
        return out;
    }

    public List<Item> getItemByCategory(String category) {
        List<Item> out;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        if (category.equals("all")) {
            out = s.createQuery("FROM Item").list();
        } else {
            Query q = s.createQuery("FROM Item where cat= :category ");
            q.setParameter("category", category);
            out = q.list();
        }
        s.getTransaction().commit();
        s.close();
        return out;
    }

    //Created by Ivan
    public List<Item> getItemByIsTop() {
        List<Item> out;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        out = (List<Item>) s.createQuery("FROM Item WHERE isTop='1'").list();
        s.getTransaction().commit();
        s.close();
        return out;
    }

    public void addItem(Item i) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
    }

    public List<Item> getItemByName(String name) {
        List<Item> out;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM Item where name like :name");
        q.setParameter("name", "%" + name + "%");
        out = q.list();
        s.getTransaction().commit();
        s.close();
        return out;
    }
     public void updateItem(Item i) {//метод обновления итемов
        Session s = HibernateUtil.getSessionFactory().openSession();//откр сесии
        s.beginTransaction();
        s.update(i);//отпрака запроса в бд с итемом
        s.getTransaction().commit();
        s.close();
    }
}

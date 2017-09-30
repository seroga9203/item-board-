package dao;

import entity.User;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class UserDAO {

    public List<User> getUsers() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<User> out = s.createQuery("FROM User").list();
        s.getTransaction().commit();
        s.close();
        return out;
    }

    public void addUser(User u) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        s.close();
    }

    public User getUserByLogin(String login) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User out = (User) s.createQuery("FROM User WHERE login='" + login + "'").uniqueResult();
        s.getTransaction().commit();
        s.close();
        return out;
    }
    public User getUserByLogin(String login, String pass) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User out = (User) s.createQuery("FROM User WHERE login='" + login + "' AND pass='"+pass+"'").uniqueResult();
        s.getTransaction().commit();
        s.close();
        return out;
    }
    public void updateUser(User u) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(u);
        s.getTransaction().commit();
        s.close();
    }
}

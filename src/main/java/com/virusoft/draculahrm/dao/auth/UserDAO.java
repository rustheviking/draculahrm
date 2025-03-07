//package com.virusoft.draculahrm.dao.auth;
//
//
//import com.virusoft.draculahrm.model.auth.User;
//import com.virusoft.draculahrm.utils.db.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class UserDAO {
//    public void saveUser(User user) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(user);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public User findByUsername(String username) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM User WHERE username = :username", User.class)
//                    .setParameter("username", username)
//                    .uniqueResult();
//        }
//    }
//}
//
//

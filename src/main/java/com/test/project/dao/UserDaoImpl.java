package com.test.project.dao;

import com.test.project.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User was successfully added: " + user);
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User was successfully update: " + user);
    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);

        if (user != null) {
            session.delete(user);
        }
        logger.info("User was successfully deleted: " + user);
    }

    public User getUserById(int id) {
        return sessionFactory
                .getCurrentSession()
                .load(User.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User").list();
    }
}

package com.learn.springboot.demosecurity.dao;

import com.learn.springboot.demosecurity.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public User findByUserName(String username) {
        TypedQuery<User> theQuery =
                entityManager.createQuery(
                        "from User where username=:uName and enabled=true", User.class
                );
        theQuery.setParameter("uName", username);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }
}

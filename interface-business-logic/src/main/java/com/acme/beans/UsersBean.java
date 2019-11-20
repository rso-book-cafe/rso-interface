package com.acme.beans;

import com.acme.users.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class UsersBean {

    @PersistenceContext(unitName = "users-jpa")
    private EntityManager em;

    public User get(int userId) {
        return em.find(User.class, userId);
    }

    public List<User> getUsers() {
        return em.createNamedQuery("User.findUsers", User.class).getResultList();
    }

    @Transactional
    public void saveUser(User user) {
        if (user != null)
            em.persist(user);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteUser(int userId) {
        User user = em.find(User.class, userId);
        if (user != null)
            em.remove(user);
    }
}

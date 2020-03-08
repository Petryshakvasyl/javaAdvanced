package ua.lviv.lgs.jpa.service;

import ua.lviv.lgs.jpa.entity.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserDao {

    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public Optional<User> findById(Integer id) {
        User user = em.find(User.class, 1);
        return Optional.ofNullable(user);
    }
}

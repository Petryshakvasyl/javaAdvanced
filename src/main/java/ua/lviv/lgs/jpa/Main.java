package ua.lviv.lgs.jpa;

import ua.lviv.lgs.jpa.entity.User;
import ua.lviv.lgs.jpa.service.UserDao;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateUnit");
        EntityManager em = emf.createEntityManager();

        UserDao userDao = new UserDao(em);

        User user = User.builder().firstName("Ivan")
                .lastName("Kirov")
                .email("irov.inva@mail.com")
                .build();

        userDao.save(user);

        User user1 = userDao.findById(1).orElseThrow(() -> new RuntimeException("user with id 1 not found"));
        System.out.println(user1);


        Query query = em.createQuery("select u from User u where u.firstName = ?1");
        query.setParameter(1, "Ivan");
        List result = query.getResultList();
        System.out.println("query: " + result);

        TypedQuery<User> typedQuery = em.createQuery("select u from User u", User.class);
        List<User> result2 = typedQuery.getResultList();
        System.out.println(" typed query: " + result2);


        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> query1 = criteriaBuilder.createQuery(User.class);
        CriteriaQuery<User> select = query1.select(query1.from(User.class));

        TypedQuery<User> typedQuery1 = em.createQuery(select);
        List<User> resultList = typedQuery1.getResultList();
        System.out.println(resultList);


    }
}

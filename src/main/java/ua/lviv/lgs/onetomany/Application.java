package ua.lviv.lgs.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg" +
                        ".xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Item item1 = new Item();
        item1.setQuantity(1000);

        Item item2 = new Item();
        item2.setQuantity(2000);

        Cart cart = new Cart();
        cart.setName("firstCart");
        //        cart.getItems().addAll(asList(item1, item2));

        item1.setCart(cart);
        item2.setCart(cart);

        Transaction transaction = session.beginTransaction();

        session.persist(item1);
        session.persist(item2);

        session.persist(cart);

        transaction.commit();

        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Cart cartFromDb = session.find(Cart.class, 3);

        cartFromDb.getItems().forEach(System.out::println);

        session.close();

    }
}

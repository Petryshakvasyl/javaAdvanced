package ua.lviv.lgs.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        FinancialOperation financialOperation = new FinancialOperation();
        financialOperation.setAmount(1000);
        financialOperation.setDate(LocalDate.now());

        Customer customer = new Customer();
        customer.setName("Test");
        customer.setEmail("test@email.com");
        customer.setFinancialOperation(financialOperation);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        //        session.persist(financialOperation);
        session.persist(customer);
        transaction.commit();

        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Customer customerFromDB = session.load(Customer.class, 2);
        session.remove(customerFromDB);

        transaction.commit();

    }
}

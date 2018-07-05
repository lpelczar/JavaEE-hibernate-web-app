package com.codecool.dao;

import com.codecool.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateCustomerDAO implements CustomerDAO {

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customers;

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

            Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
            customers = query.getResultList();
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

        return customers;
    }
}

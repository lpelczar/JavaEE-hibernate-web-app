package com.codecool.dao;

import com.codecool.model.Customer;
import com.codecool.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateCustomerDAO implements CustomerDAO {

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();
        currentSession.getTransaction().commit();
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(customer);
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
        currentSession.getTransaction().commit();
    }
}

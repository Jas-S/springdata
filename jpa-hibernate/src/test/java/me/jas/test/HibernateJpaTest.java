package me.jas.test;

import me.jas.pojo.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateJpaTest {

    EntityManagerFactory factory;

    @BeforeEach
    public void before_each() {
        factory = Persistence.createEntityManagerFactory("hibernateJPA");
    }

    @Test
    public void addTest() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustomerName("tom");
        entityManager.persist(customer);
        transaction.commit();
    }

    @Test
    public void getCustomerTest() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println("--------------");
        System.out.println(customer);
        transaction.commit();
    }

    @Test
    public void lazyGetCustomerTest() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println("===============");
        System.out.println(customer);
        transaction.commit();
    }
}

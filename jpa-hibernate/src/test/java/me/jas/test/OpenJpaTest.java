package me.jas.test;

import me.jas.pojo.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OpenJpaTest {

    EntityManagerFactory factory;

    @BeforeEach
    public void before_each() {
        factory = Persistence.createEntityManagerFactory("openJpa");
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
}

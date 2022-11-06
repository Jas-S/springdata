package me.jas.test;

import me.jas.pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HibernateJpaTest {

    EntityManagerFactory factory;

    @BeforeMethod
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

    @Test
    public void updateOrInsertTest() {
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer();

        /*
          若指定了主键:
                   会先查询看是否有变化，如有变化则更新，无变化则不更新
          若没有指定主键：
                   执行插入
         */
        customer.setCustomerId(1L);
        customer.setCustomerName("jason");
        entityManager.merge(customer);
        transaction.commit();
    }
}

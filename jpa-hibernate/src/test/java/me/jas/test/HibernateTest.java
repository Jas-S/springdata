package me.jas.test;

import me.jas.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HibernateTest {
    private SessionFactory sf;

    @BeforeEach
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate_config.xml").build();
        // 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用唯一的session工厂
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void addCustomerTest() {
        // 进行持久化操作
        try(Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCustomerName("jas");
            session.save(customer);
            transaction.commit();
        }
    }

    @Test
    public void getCustomerByIdTest() {
        try(Session session = sf.openSession()) {
            //Customer customer = session.find(Customer.class, 1L);
            // 懒加载，直到customer对象被使用时才会执行查询。因此下面的分割线会先于sql出现。
            Customer customer = session.load(Customer.class, 1L);
            System.out.println("------------------------");
            System.out.println(customer);
        }
    }
}

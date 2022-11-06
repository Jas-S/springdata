package me.jas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    /**
     * @GeneratedValue:配置主键的生成策略
     *      strategy
     *          GenerationType.IDENTITY 自增，MySQL
     *          GenerationType.SEQUENCE 序列，oracle
     *          GenerationType.TABLE jpa提供的一种机制，通过一张数据库表的形式帮我们完成主键生成
     *          GenerationType.AUTO 由程序自动选择主键生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;

    @Column(name = "name")
    private String customerName;

    @Column(name = "address")
    private String customerAddress;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}

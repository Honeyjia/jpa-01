package com.jiaool.domain;

import javax.persistence.*;

/*
客户的实体类
    配置的映射关系
    1.实体类和表的映射关系
    @Entity：声明实体类
    @Table：配置实体类和表的映射关系
        name：配置数据库表的名称
    2.实体类中的属性和表中字段的映射关系

 */
@Entity//声明实体类
@Table(name = "cst_customer")
public class Customer {
    /*
    @id 声明主键的配置
    @GeneratedValue  配置主键的生成策略
            GenerationType.IDENTITY  自增 mysql
                    * 底层数据库必须自动增长（底层数据库支持的自动增长方式，对id自增）
            GenerationType.SEQUENCE  序列  oracle
                    * 底层数据库必须支持序列
            GenerationType.TABLE     jpa提供的一种机制，通过一张数据表的形式帮助我们完成主键自增
            GenerationType.AUTO      由程序自动帮助我们选择主键生成策略

    @Column 配置属性和字段的映射关系
            name  数据库表中的字段名称
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;  //客户的主键

    @Column(name = "cust_name")
    private String custName; //客户名称

    @Column(name = "cust_source")
    private String custSource; //客户来源

    @Column(name = "cust_level")
    private String custLevel; //客户级别

    @Column(name = "cust_industry")
    private String custIndustry; //客户所属行业

    @Column(name = "cust_phone")
    private String custPhone; //客户的联系方式

    @Column(name = "cust_address")
    private String custAdress; //客户

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAdress() {
        return custAdress;
    }

    public void setCustAdress(String custAdress) {
        this.custAdress = custAdress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAdress='" + custAdress + '\'' +
                '}';
    }
}

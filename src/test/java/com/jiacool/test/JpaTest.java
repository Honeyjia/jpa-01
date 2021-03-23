package com.jiacool.test;

import com.jiaool.Utils.JpaUtils;
import com.jiaool.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
    /**
     * 测试jpa的保存
     * 1.加载配置文件创建工厂（实体管理器工厂）对象
     * 2.通过实体管理器工厂获取实体管理器
     * 3.获取事务对象
     * 4.完成事务对象，开启事务
     * 5.提交事务，开启事务
     * 6.释放资源
     */
    @Test
    public void test(){
      /*  //1.加载配置文件创建工厂（实体管理器工厂）对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        //2.通过实体管理器工厂获取实体管理器
        EntityManager manager = factory.createEntityManager();*/
        EntityManager manager = JpaUtils.getEntityManager();
        //3.获取事务对象
        EntityTransaction transaction = manager.getTransaction();
        //4.开启事务
        transaction.begin();
        //，保存一个客户到数据库
        Customer customer = new Customer();
        customer.setCustName("传智博客");
        customer.setCustIndustry("教育");
        customer.setCustAdress("上海浦东");
        //保存
        manager.persist(customer);
        //6.提交事务
        transaction.commit();
        //7.释放资源
        manager.close();
        // factory.close();
    }

    //根据id查询
    @Test
    public void testFind(){
        //获取 EntityManager 实体管理器对象
        EntityManager manager = JpaUtils.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = manager.getTransaction();
        //开启事务
        transaction.begin();
        //查询 根据id
        /**
         * find:根据id查询
         *      class：查询数据的结果 需要包装的实体类类型的字节码
         *      id：查询的主键的取值
         */
//        Customer customer = manager.find(Customer.class, 1l);//立即加载
        Customer customer = manager.getReference(Customer.class, 1l);//延迟加载
        System.out.println(customer);
        //提交事务
        transaction.commit();
        //释放资源
        manager.close();
    }

    //删除客户
    @Test
    public void testDelete(){
        //获取 EntityManager 实体管理器对象
        EntityManager manager = JpaUtils.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = manager.getTransaction();
        //开启事务
        transaction.begin();
        //删除 先根据id查询一个客对象，再调用remove方法删除，remove方法中的参数是一个object对象
        //根据id查询客户
        Customer customer = manager.find(Customer.class, 1l);
        //调用remove方法完成删除操作
        manager.remove(customer);
        System.out.println(customer);
        //提交事务
        transaction.commit();
        //释放资源
        manager.close();
    }

    //更新操作
    @Test
    public void testUpdate(){
        //获取 EntityManager 实体管理器对象
        EntityManager manager = JpaUtils.getEntityManager();
        //获取事务对象
        EntityTransaction transaction = manager.getTransaction();
        //开启事务
        transaction.begin();
        //更新 先根据id查询一个客户对象，可以修改某些属性的值，再调用merge方法，merge方法中的参数是一个object对象
        //根据id查询客户
        Customer customer = manager.find(Customer.class, 2l);
        customer.setCustIndustry("媒体");
        //调用merge方法完成删除操作
        manager.merge(customer);
        System.out.println(customer);
        //提交事务
        transaction.commit();
        //释放资源
        manager.close();
    }

}

package com.jiacool.test;

import com.jiaool.Utils.JpaUtils;
import com.jiaool.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {

    //查询全部
    @Test
    public void test1(){
        /**
         * jpql: from Customer/com.jiacool.domain.Customer 查询实体类和实体中的属性
         * sql: select * from cst_customer   查询数据库表和表的字段名
         */
        //1.获取EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //3.开启事务
        transaction.begin();
        //4.执行查询全部操作
        String jpql = "from Customer";  //编写jpql语句
        Query query = entityManager.createQuery(jpql);//创建query查询对象  query才是执行jpql的对象
        List list = query.getResultList();//发送查询 并封装结果集
        for (Object cst : list) {
            System.out.println(cst);
        }
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();
    }

    //排序查询
    @Test
    public void test2(){
        /**
         * jpql: from Customer/com.jiacool.domain.Customer order by custId desc
         * sql: select * from cst_customer ORDER BY cust_id DESC;   降序查询全部
         */
        //1.获取EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //3.开启事务
        transaction.begin();
        //4.执行查询全部操作
        String jpql = "from Customer order by custId desc";  //编写jpql语句
        Query query = entityManager.createQuery(jpql);//创建query查询对象  query才是执行jpql的对象
        List list = query.getResultList();//发送查询 并封装结果集
        for (Object cst : list) {
            System.out.println(cst);
        }
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();
    }

    //统计查询
    @Test
    public void test3(){
        /**
         * jpql: select count(custId) from Customer/com.jiacool.domain.Customer
         * sql: SELECT COUNT(cust_id) FROM cst_customer;   查询个数
         */
        //1.获取EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //3.开启事务
        transaction.begin();
        //4.执行查询全部操作
        //根据jpql语句创建query查询对象
        String jpql = "select count(custId) from Customer ";
        Query query = entityManager.createQuery(jpql);
        /**
         * getResultList : 将查询结果封装为 List 集合
         *getSingleResult : 得到唯一的结果集
         */
        Object count = query.getSingleResult();
        System.out.println(count);
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();
    }

    //分页查询
    /**
     * jpql: from Customer/com.jiacool.domain.Customer
     * sql: SELECT * FROM cst_customer LIMIT 0, 2;   分页
     */
    @Test
    public void test4(){
        //1.获取EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //3.开启事务
        transaction.begin();
        //4.分页查询：先查询全部，再设置参数
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);
        /**
         * 对参数赋值 -- 分页查询
         * setFirstResult：  起始索引
         *setMaxResults：  每页查询的条数
         */
        query.setFirstResult(0);
        query.setMaxResults(2);
        List resultList = query.getResultList();
        for (Object cst : resultList) {
            System.out.println(cst);
        }
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();
    }


    /*
    条件查询：查找cust_name 是以 传智 开头的客户
     */
    @Test
    public void test5(){
        /**
         * jpql: from Customer/com.jiacool.domain.Customer where custName like ?
         * sql: SELECT * FROM cst_customer WHERE cust_name LIKE "传智%";   模糊查询
         */
        //1.获取EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //3.开启事务
        transaction.begin();
        //4.分页查询：先查询全部，再设置参数
        String jpql = "from Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);
        /**
         * 对参数赋值 -- 占位符
         * setParameter：
         *      第一个参数：占位符的索引位置（从1开始）
         *      第二个参数：取值
         */
        query.setParameter(1,"传智%");

        List resultList = query.getResultList();
        for (Object cst : resultList) {
            System.out.println(cst);
        }
        //5.提交事务
        transaction.commit();
        //6.释放资源
        entityManager.close();
    }


}

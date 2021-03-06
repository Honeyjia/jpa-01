package com.jiaool.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    /**
     * 解决实体管理器工厂的浪费和耗时问题
     * 通过静态代码块的形式，当程序第一次访问此工具类时，创建一个公共的实体管理器工厂对象
     *
     * 第一次访问getEntityManager方法时，经过静态代码块创建一个factory对象，再调用方法创建一个EntityManger对象
     * 第二次访问getEntityManager方法时，直接通过一个已经创建好的factory对象，创建EntityManger对象
     */

    private static EntityManagerFactory factory;
    static {
        //1.加载配置文件，创建EntityManagerFactory
        factory = Persistence.createEntityManagerFactory("jpa");
    }
    //获取EntityManager对象
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}

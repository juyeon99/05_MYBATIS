package com.ohgiraffers.practice.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/employee_db";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            Environment env = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER,URL,USER,PASSWORD)
            );
            Configuration config = new Configuration(env);
            config.addMapper(EmployeeMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        }
        return sqlSessionFactory.openSession(false);
    }
}

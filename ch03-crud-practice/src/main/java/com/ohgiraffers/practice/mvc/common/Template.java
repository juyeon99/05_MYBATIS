package com.ohgiraffers.practice.mvc.common;

import com.ohgiraffers.practice.mvc.dao.EmployeeMapper;
import com.ohgiraffers.practice.mvc.dao.JobMapper;
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
            config.addMapper(JobMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        }
        return sqlSessionFactory.openSession(false);
    }
}

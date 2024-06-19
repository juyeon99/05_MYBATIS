package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /*
    * SqlSessionFactory는 어플리케이션 실행하는 동안 존재해야 하며,
    * 어플리케이션이 실행되는 동안 여러차례 SqlSessionFactory를 다시 빌드하지 않는 것이 좋은 형태
    * 따라서, 어플리케이션 스코프를 관리하기 위한 가장 간단한 방법인 싱글턴 패턴을 사용해서 관리
    * */

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        /*
        * SqlSessionFactoryBuilder는 SqlSession을 생성한 후에 유지할 필요가 없다.
        * 따라서, 메소드 스코프로 만든다.
        * */

        if (sqlSessionFactory == null){
            String resource = "mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory의 hashCode(): " + sqlSessionFactory.hashCode());   // 하나의 객체
        System.out.println("sqlSession의 hashCode(): " + sqlSession.hashCode() + "\n");  // 출력할 때마다 다 다른 객체

        return sqlSession;
    }
}

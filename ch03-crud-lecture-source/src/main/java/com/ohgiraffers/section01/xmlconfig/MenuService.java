package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    /*
    * Service
    *
    * 비즈니스 로직을 수행하는 클래스라고도 함.
    * 주로 DAO가 DB에서 받아온 데이터를 전달받아 가공해 Controller로 return 해준다.
    *
    * MyBatis에서 Service의 역할
    * 1. SqlSession 생성 및 닫기
    * 2. DAO(DB 접근 객체)의 메소드 호출
    * 3. 트랜젝션(commit, rollback) 제어
    * */

    private final MenuDAO menuDAO;

    public MenuService(){
        menuDAO = new MenuDAO();
    }

    List<MenuDTO> selectAllMenu(){
        // 1. SqlSession 열어주기
        SqlSession sqlSession = getSqlSession();

        // 2. MenuDAO를 이용해 DB에서 menuList 가져오기
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        // 세션 닫아주기
        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {
        // 1. SqlSession 열어주기
        SqlSession sqlSession = getSqlSession();

        // 2. MenuDAO를 이용해 DB에서 menu 가져오기
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession,code);

        // 세션 닫아주기
        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        // 1. SqlSession 열어주기
        SqlSession sqlSession = getSqlSession();

        // 2. MenuDAO를 이용해 DB에서 성공여부 반환받기
        int result = menuDAO.insertMenu(sqlSession,menu);

        // 3. result 결과값에 따라 insert, update, delete는 트랜젝션 처리를 해주어야 함
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        // 세션 닫아주기
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        // 1. SqlSession 열어주기
        SqlSession sqlSession = getSqlSession();

        // 2. MenuDAO를 이용해 DB에서 성공여부 반환받기
        int result = menuDAO.updateMenu(sqlSession,menu);

        // 3. 트랜젝션 처리
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        // 세션 닫아주기
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(int code) {
        // 1. SqlSession 열어주기
        SqlSession sqlSession = getSqlSession();

        // 2. MenuDAO를 이용해 DB에서 성공여부 반환받기
        int result = menuDAO.deleteMenu(sqlSession,code);

        // 3. 트랜젝션 처리
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        // 세션 닫아주기
        sqlSession.close();

        return result > 0;
    }
}

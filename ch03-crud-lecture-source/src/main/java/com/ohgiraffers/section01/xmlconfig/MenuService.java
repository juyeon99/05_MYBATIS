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
}

package com.ohgiraffers.section03.remix;

import java.util.List;

// DB 접근을 하기 때문에 DAO 인터페이스라고 한다.
public interface MenuMapper {
    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int code);
}

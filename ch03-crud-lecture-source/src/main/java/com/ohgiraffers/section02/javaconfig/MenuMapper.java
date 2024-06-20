package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {
    @Results(id = "menuResultMap", value = {
            @Result(id = true /*PK*/, property = "code", column = "menu_code"),
            @Result(property = "name", column = "menu_name"),
            @Result(property = "price", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })

    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status\n" +
            "FROM tbl_menu\n" +
            "WHERE orderable_status = 'Y'\n" +
            "ORDER BY menu_code")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status\n" +
            "FROM tbl_menu\n" +
            "WHERE menu_code = #{code}")
    @ResultMap("menuResultMap")     // MenuDTO로 변환
    MenuDTO selectMenuByCode(int code);

    @Insert("INSERT INTO tbl_menu (menu_name, menu_price, category_code, orderable_status)\n" +
            "        VALUES (#{name},#{price},#{categoryCode},'Y')")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE tbl_menu\n" +
            "SET menu_name = #{name},\n" +
            "    menu_price = #{price},\n" +
            "    category_code = #{categoryCode}\n" +
            "WHERE menu_code = #{code}")
    int modifyMenu(MenuDTO menu);

    @Delete("DELETE\n" +
            "FROM tbl_menu\n" +
            "WHERE menu_code = #{code}")
    int deleteMenu(int code);
}

package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Mapper {
//    @Select("/* 쿼리문 작성위치 */")
//    @Update()
//    @Delete()
//    @Insert()

    @Select("select curdate()")
    java.util.Date/* <- 반환타입 | 메소드 명 -> */ selectSysdate();
}

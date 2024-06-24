package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

public interface ElementTestMapper {
    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();
}

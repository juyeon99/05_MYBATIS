package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DeptAndEmployeeDTO;
import com.ohgiraffers.common.EmployeeAndDeptDTO;

import java.util.List;

public interface ElementTestMapper {
    List<EmployeeAndDeptDTO> selectEmployeeAndDeptName();

    List<DeptAndEmployeeDTO> selectDeptAndEmployees();
}

package com.ohgiraffers.practice.remix;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployees();

    EmployeeDTO selectEmployeeById(String empId);

    EmployeeDTO selectEmployeeByName(String empName);

    int insertEmployee(EmployeeDTO emp);

    int updateEmployee(EmployeeDTO emp);

    int deleteEmployee(String empId);
}

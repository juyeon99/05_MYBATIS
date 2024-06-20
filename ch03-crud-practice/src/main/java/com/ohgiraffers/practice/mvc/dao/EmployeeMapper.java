package com.ohgiraffers.practice.mvc.dao;

import com.ohgiraffers.practice.mvc.dto.EmployeeDTO;
import com.ohgiraffers.practice.mvc.dto.JobAvgSalaryDTO;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectAllEmployees();

    EmployeeDTO selectEmployeeById(String empId);

    EmployeeDTO selectEmployeeByName(String empName);

    int insertEmployee(EmployeeDTO emp);

    int updateEmployee(EmployeeDTO emp);

    int deleteEmployee(String empId);

    List<JobAvgSalaryDTO> printAvgSalaryByJobCode();
}

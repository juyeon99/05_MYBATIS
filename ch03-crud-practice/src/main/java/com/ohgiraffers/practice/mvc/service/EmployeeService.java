package com.ohgiraffers.practice.mvc.service;

import com.ohgiraffers.practice.mvc.dao.EmployeeMapper;
import com.ohgiraffers.practice.mvc.dto.EmpListByDeptDTO;
import com.ohgiraffers.practice.mvc.dto.EmployeeDTO;
import com.ohgiraffers.practice.mvc.dto.JobAvgSalaryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.mvc.common.Template.getSqlSession;

public class EmployeeService {
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> selectAllEmployees() {
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> empList = employeeMapper.selectAllEmployees();

        sqlSession.close();

        return empList;
    }

    public EmployeeDTO selectEmployeeById(String empId) {
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeDTO emp = employeeMapper.selectEmployeeById(empId);

        sqlSession.close();

        return emp;
    }

    public EmployeeDTO selectEmployeeByName(String empName) {
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeDTO emp = employeeMapper.selectEmployeeByName(empName);

        sqlSession.close();

        return emp;
    }

    public boolean registerEmployee(EmployeeDTO emp) {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.insertEmployee(emp);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyEmployee(EmployeeDTO emp) {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.updateEmployee(emp);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteEmployee(String empId) {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.deleteEmployee(empId);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public List<JobAvgSalaryDTO> printAvgSalaryByJobCode() {
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<JobAvgSalaryDTO> avgSalList = employeeMapper.printAvgSalaryByJobCode();

        sqlSession.close();

        return avgSalList;
    }

    public List<EmployeeDTO> selectAllEmployeesByDeptCode() {
        SqlSession sqlSession = getSqlSession();

        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> empDeptList = employeeMapper.selectAllEmployeesByDeptCode();

        sqlSession.close();

        return empDeptList;
    }
}

package com.ohgiraffers.practice.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.remix.Template.getSqlSession;

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
}

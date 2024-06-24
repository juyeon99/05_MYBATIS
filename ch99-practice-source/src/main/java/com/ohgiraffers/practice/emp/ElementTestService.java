package com.ohgiraffers.practice.emp;

import com.ohgiraffers.common.DeptAndEmployeeDTO;
import com.ohgiraffers.common.EmployeeAndDeptDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {
    private ElementTestMapper mapper;

    public void selectEmployeeAndDeptName() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<EmployeeAndDeptDTO> empList = mapper.selectEmployeeAndDeptName();
        for (EmployeeAndDeptDTO emp : empList){
            System.out.println("사원이름: " + emp.getEmpName() + ", 부서명: " + emp.getDepartment().getDeptTitle());
        }

        sqlSession.close();
    }

    public void selectDeptAndEmployees() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<DeptAndEmployeeDTO> deptList = mapper.selectDeptAndEmployees();
        for (DeptAndEmployeeDTO dept : deptList){
            System.out.println(dept);
        }

        sqlSession.close();
    }
}

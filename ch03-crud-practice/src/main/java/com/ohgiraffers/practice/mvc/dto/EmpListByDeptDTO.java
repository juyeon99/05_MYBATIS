package com.ohgiraffers.practice.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class EmpListByDeptDTO {
    private List<EmployeeDTO> empList = new ArrayList<>();
    private String deptCode;

    public EmpListByDeptDTO() {
    }

    public EmpListByDeptDTO(List<EmployeeDTO> empList, String deptCode) {
        this.empList = empList;
        this.deptCode = deptCode;
    }

    public List<EmployeeDTO> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmployeeDTO> empList) {
        this.empList = empList;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Override
    public String toString() {
        return "EmpListByDeptDTO{" +
                "empList=" + empList +
                ", deptCode='" + deptCode + '\'' +
                '}';
    }
}

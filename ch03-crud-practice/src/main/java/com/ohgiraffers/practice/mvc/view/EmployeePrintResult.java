package com.ohgiraffers.practice.mvc.view;

import com.ohgiraffers.practice.mvc.dto.EmployeeDTO;
import com.ohgiraffers.practice.mvc.dto.JobAvgSalaryDTO;

import java.util.List;

public class EmployeePrintResult {
    public void printEmployeeList(List<EmployeeDTO> empList) {
        for (EmployeeDTO emp : empList){
            System.out.println(emp);
        }
    }

    public void printEmployee(EmployeeDTO emp) {
        System.out.println(emp);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){
            case "insert":
                successMessage = "신규 메뉴 등록을 성공했습니다.";
                break;
            case "update":
                successMessage = "메뉴 수정을 성공했습니다.";
                break;
            case "delete":
                successMessage = "메뉴 삭제를 성공했습니다.";
                break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "selectList":
                errorMessage = "직원 목록 조회를 실패했습니다.";
                break;
            case "selectOne":
                errorMessage = "직원 정보 조회를 실패했습니다.";
                break;
            case "insert":
                errorMessage = "직원 정보 등록을 실패했습니다.";
                break;
            case "update":
                errorMessage = "직원 정보 수정을 실패했습니다.";
                break;
            case "delete":
                errorMessage = "직원 정보 삭제를 실패했습니다.";
                break;
            case "selectAvgSal":
                errorMessage = "평균 임금 구하기에 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }

    public void printAvgSalaryList(List<JobAvgSalaryDTO> avgSalList) {
        for (JobAvgSalaryDTO avgSalary : avgSalList){
            System.out.println(avgSalary);
        }
    }
}

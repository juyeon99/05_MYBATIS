package com.ohgiraffers.practice.mvc.view;

import com.ohgiraffers.practice.mvc.dto.EmployeeDTO;
import com.ohgiraffers.practice.mvc.dto.JobDTO;

import java.util.List;

public class JobPrintResult {
    public void printJobList(List<JobDTO> jobList) {
        for (JobDTO job : jobList){
            System.out.println(job);
        }
    }

    public void printJob(JobDTO job) {
        System.out.println(job);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){
            case "insert":
                successMessage = "신규 직급 등록을 성공했습니다.";
                break;
            case "update":
                successMessage = "직급 수정을 성공했습니다.";
                break;
            case "delete":
                successMessage = "직급 삭제를 성공했습니다.";
                break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "selectList":
                errorMessage = "직급 목록 조회를 실패했습니다.";
                break;
            case "selectOne":
                errorMessage = "직급 정보 조회를 실패했습니다.";
                break;
            case "insert":
                errorMessage = "직급 정보 등록을 실패했습니다.";
                break;
            case "update":
                errorMessage = "직급 정보 수정을 실패했습니다.";
                break;
            case "delete":
                errorMessage = "직급 정보 삭제를 실패했습니다.";
                break;
        }
        System.out.println(errorMessage);
    }
}

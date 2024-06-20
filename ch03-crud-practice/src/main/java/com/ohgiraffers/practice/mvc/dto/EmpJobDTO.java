package com.ohgiraffers.practice.mvc.dto;

public class EmpJobDTO {
    private String empId;
    private String empName;
    private String jobCode;
    private String jobName;

    public EmpJobDTO() {
    }

    public EmpJobDTO(String empId, String empName, String jobCode, String jobName) {
        this.empId = empId;
        this.empName = empName;
        this.jobCode = jobCode;
        this.jobName = jobName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "EmpJobDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}

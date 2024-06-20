package com.ohgiraffers.practice.mvc.dto;

public class JobAvgSalaryDTO {
    private String jobCode;
    private double avgSalary;

    public JobAvgSalaryDTO() {
    }

    public JobAvgSalaryDTO(String jobCode, double avgSalary) {
        this.jobCode = jobCode;
        this.avgSalary = avgSalary;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "JobAvgSalaryDTO{" +
                "jobCode='" + jobCode + '\'' +
                ", avgSalary=" + avgSalary +
                '}';
    }
}

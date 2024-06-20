package com.ohgiraffers.practice.mvc.controller;

import com.ohgiraffers.practice.mvc.dto.JobDTO;
import com.ohgiraffers.practice.mvc.service.JobService;
import com.ohgiraffers.practice.mvc.view.JobPrintResult;

import java.util.List;
import java.util.Map;

public class JobController {
    private final JobPrintResult printResult;
    private final JobService jobService;

    public JobController() {
        printResult = new JobPrintResult();
        jobService = new JobService();
    }

    public void selectAllJobs() {
        List<JobDTO> jobList = jobService.selectAllJobs();

        // view로 전달
        if (jobList != null){
            printResult.printJobList(jobList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectJobByCode(Map<String, String> param){
        String jobCode = param.get("jobCode");
        JobDTO job = jobService.selectJobByCode(jobCode);

        // view로 전달
        if (job != null){
            printResult.printJob(job);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectJobByName(Map<String, String> param){
        String jobName = param.get("jobName");
        JobDTO job = jobService.selectJobByName(jobName);

        // view로 전달
        if (job != null){
            printResult.printJob(job);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registerJob(Map<String, String> param) {
        String jobCode = param.get("jobCode");
        String jobName = param.get("jobName");

        JobDTO job = new JobDTO();
        job.setJobCode(jobCode);
        job.setJobName(jobName);

        boolean result = jobService.registerJob(job);

        if (result){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyJob(Map<String, String> param) {
        String jobCode = param.get("jobCode");
        String jobName = param.get("jobName");

        JobDTO job = new JobDTO();
        job.setJobCode(jobCode);
        job.setJobName(jobName);

        boolean result = jobService.modifyJob(job);

        if (result){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteJob(Map<String, String> param) {
        String jobCode = param.get("jobCode");

        boolean result = jobService.deleteJob(jobCode);

        if (result){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}

package com.ohgiraffers.practice.mvc.dao;

import com.ohgiraffers.practice.mvc.dto.JobDTO;

import java.util.List;

public interface JobMapper {
    List<JobDTO> selectAllJobs();

    JobDTO selectJobByCode(String jobCode);

    JobDTO selectJobByName(String jobName);

    int insertJob(JobDTO job);

    int updateJob(JobDTO job);

    int deleteJob(String jobCode);
}

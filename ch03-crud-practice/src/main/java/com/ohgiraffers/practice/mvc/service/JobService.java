package com.ohgiraffers.practice.mvc.service;

import com.ohgiraffers.practice.mvc.dao.JobMapper;
import com.ohgiraffers.practice.mvc.dto.JobDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.mvc.common.Template.getSqlSession;

public class JobService {
    private JobMapper jobMapper;

    public List<JobDTO> selectAllJobs() {
        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);
        List<JobDTO> empList = jobMapper.selectAllJobs();

        sqlSession.close();

        return empList;
    }

    public JobDTO selectJobByCode(String jobCode) {
        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);
        JobDTO emp = jobMapper.selectJobByCode(jobCode);

        sqlSession.close();

        return emp;
    }

    public JobDTO selectJobByName(String jobName) {
        SqlSession sqlSession = getSqlSession();

        jobMapper = sqlSession.getMapper(JobMapper.class);
        JobDTO emp = jobMapper.selectJobByName(jobName);

        sqlSession.close();

        return emp;
    }

    public boolean registerJob(JobDTO job) {
        SqlSession sqlSession = getSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.insertJob(job);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyJob(JobDTO job) {
        SqlSession sqlSession = getSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.updateJob(job);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteJob(String jobCode) {
        SqlSession sqlSession = getSqlSession();
        jobMapper = sqlSession.getMapper(JobMapper.class);

        int result = jobMapper.deleteJob(jobCode);
        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }
}

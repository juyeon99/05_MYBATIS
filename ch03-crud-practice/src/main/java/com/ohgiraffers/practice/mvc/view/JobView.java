package com.ohgiraffers.practice.mvc.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JobView {
    public Map<String, String> inputJobCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("직급 코드 입력: ");
        String jobCode = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("jobCode",jobCode);

        return param;
    }

    public Map<String, String> inputJobName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("직급 이름 입력: ");
        String jobName = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("jobName",jobName);

        return param;
    }

    public Map<String, String> inputJob() {
        Scanner sc = new Scanner(System.in);
        System.out.print("직급 코드 입력: ");
        String jobCode = sc.nextLine();
        System.out.print("직급 이름 입력: ");
        String jobName = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("jobCode",jobCode);
        param.put("jobName",jobName);

        return param;
    }

    public Map<String, String> inputModifyJob() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직급 코드 입력: ");
        String jobCode = sc.nextLine();
        System.out.print("수정할 직급 이름 입력: ");
        String jobName = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("jobCode",jobCode);
        param.put("jobName",jobName);

        return param;
    }
}

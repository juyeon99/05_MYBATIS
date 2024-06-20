package com.ohgiraffers.practice.mvc.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeView {
    public Map<String, String> inputEmployeeCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 ID 입력: ");
        String empId = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("empId",empId);

        return param;
    }

    public Map<String, String> inputEmployeeName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 이름 입력: ");
        String empName = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("empName",empName);

        return param;
    }

    public Map<String, String> inputEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 ID 입력: ");
        String empId = sc.nextLine();
        System.out.print("직원 이름 입력: ");
        String empName = sc.nextLine();
        System.out.print("직원 주민등록번호 입력: ");
        String empNo = sc.nextLine();
        System.out.print("직원 직업코드 입력: ");
        String jobCode = sc.nextLine();
        System.out.print("직원 급여등급 입력: ");
        String salLevel = sc.nextLine();

        Map<String,String> param = new HashMap<>();
        param.put("empId",empId);
        param.put("empName",empName);
        param.put("empNo",empNo);
        param.put("jobCode",jobCode);
        param.put("salLevel",salLevel);

        return param;
    }

    public Map<String, String> inputModifyEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 직원 ID 입력: ");
        String empId = sc.nextLine();
        System.out.print("수정할 직원 이름 입력: ");
        String empName = sc.nextLine();
        System.out.print("수정할 직원 주민등록번호 입력: ");
        String empNo = sc.nextLine();
        System.out.print("수정할 직원 직업코드 입력: ");
        String jobCode = sc.nextLine();
        System.out.print("수정할 직원 급여등급 입력: ");
        String salLevel = sc.nextLine();

        Map<String,String> param = new HashMap<>();
        param.put("empId",empId);
        param.put("empName",empName);
        param.put("empNo",empNo);
        param.put("jobCode",jobCode);
        param.put("salLevel",salLevel);

        return param;
    }
}

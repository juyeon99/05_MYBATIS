package com.ohgiraffers.practice.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeController empController = new EmployeeController();
        boolean flag = true;

        do{
            System.out.println("\n===== 직원 관리 시스템 =====");
            System.out.println("1. 모든 직원 조회\n" +
                    "2. 직원 ID로 조회\n" +
                    "3. 직원 이름으로 조회\n" +
                    "4. 직원 추가\n" +
                    "5. 직원 수정\n" +
                    "6. 직원 삭제\n" +
                    "0. 프로그램 종료\n" +
                    "-----------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    empController.selectAllEmployees();
                    break;
                case 2:
                    empController.selectEmployeeById(inputEmployeeCode());
                    break;
                case 3:
                    empController.selectEmployeeByName(inputEmployeeName());
                    break;
                case 4:
                    empController.registerEmployee(inputEmployee());
                    break;
                case 5:
                    empController.modifyEmployee(inputModifyEmployee());
                    break;
                case 6:
                    empController.deleteEmployee(inputEmployeeCode());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
                    break;
            }
        } while(flag);
    }

    private static Map<String, String> inputEmployeeCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 ID 입력: ");
        String empId = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("empId",empId);

        return param;
    }

    private static Map<String, String> inputEmployeeName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("직원 이름 입력: ");
        String empName = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("empName",empName);

        return param;
    }

    private static Map<String, String> inputEmployee(){
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

    private static Map<String, String> inputModifyEmployee(){
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

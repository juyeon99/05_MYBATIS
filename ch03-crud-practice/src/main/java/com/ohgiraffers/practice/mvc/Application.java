package com.ohgiraffers.practice.mvc;

import com.ohgiraffers.practice.mvc.controller.EmployeeController;
import com.ohgiraffers.practice.mvc.controller.JobController;
import com.ohgiraffers.practice.mvc.view.EmployeeView;
import com.ohgiraffers.practice.mvc.view.JobView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeController empController = new EmployeeController();
        JobController jobController = new JobController();
        boolean flag = true;

        do{
            System.out.println("\n-----------------------------");
            System.out.println("1. 직원 관리 시스템\n2. 직급 관리 시스템\n3. 임직원의 월급 평균 확인하기\n" +
                    "4. 부서별 임직원 조회하기\n5. 임직원 직급 이름 조회\n0. 프로그램 종료");
            System.out.print("선택: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
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
                    no = sc.nextInt();

                    EmployeeView empView = new EmployeeView();

                    switch (no){
                        case 1:
                            empController.selectAllEmployees();
                            break;
                        case 2:
                            empController.selectEmployeeById(empView.inputEmployeeCode());
                            break;
                        case 3:
                            empController.selectEmployeeByName(empView.inputEmployeeName());
                            break;
                        case 4:
                            empController.registerEmployee(empView.inputEmployee());
                            break;
                        case 5:
                            empController.modifyEmployee(empView.inputModifyEmployee());
                            break;
                        case 6:
                            empController.deleteEmployee(empView.inputEmployeeCode());
                            break;
                        case 0:
                            flag = false;
                            break;
                        default:
                            System.out.println("잘못된 번호를 선택하셨습니다.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\n===== 직급 관리 시스템 =====");
                    System.out.println("1. 모든 직급 조회\n" +
                            "2. 직급 코드로 조회\n" +
                            "3. 직급 이름으로 조회\n" +
                            "4. 직급 추가\n" +
                            "5. 직급 수정\n" +
                            "6. 직급 삭제\n" +
                            "0. 프로그램 종료\n" +
                            "-----------------------------");
                    System.out.print("번호 입력: ");
                    no = sc.nextInt();

                    JobView jobView = new JobView();

                    switch (no){
                        case 1:
                            jobController.selectAllJobs();
                            break;
                        case 2:
                            jobController.selectJobByCode(jobView.inputJobCode());
                            break;
                        case 3:
                            jobController.selectJobByName(jobView.inputJobName());
                            break;
                        case 4:
                            jobController.registerJob(jobView.inputJob());
                            break;
                        case 5:
                            jobController.modifyJob(jobView.inputModifyJob());
                            break;
                        case 6:
                            jobController.deleteJob(jobView.inputJobCode());
                            break;
                        case 0:
                            flag = false;
                            break;
                        default:
                            System.out.println("잘못된 번호를 선택하셨습니다.");
                            break;
                    }
                    break;

                case 3: // 임직원의 월급 평균 확인하기
                    empController.printAvgSalaryByJobCode();
                    break;
                case 4: // 부서별 임직원 조회하기
                    empController.selectAllEmployeesByDeptCode();
                    break;
                case 5: // 임직원 직급 이름 조회
                    empController.selectEmployeeNameAndJobName();
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
}

package com.ohgiraffers.section03.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        boolean flag = true;

        do{
            System.out.println("\n===== 메뉴 관리 시스템 =====");
            System.out.println("1. 메뉴 전체조회\n" +
                    "2. 메뉴 코드로 메뉴 조회\n" +
                    "3. 신규 메뉴 추가\n" +
                    "4. 메뉴 수정\n" +
                    "5. 메뉴 삭제\n" +
                    "0. 프로그램 종료\n" +
                    "-----------------------------");
            System.out.print("메뉴 관리 번호를 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2:
                    menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3:
                    menuController.registerMenu(inputMenu());
                    break;
                case 4:
                    menuController.modifyMenu(inputModifyMenu());
                    break;
                case 5:
                    menuController.deleteMenu(inputMenuCode());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        } while(flag);
    }

    // 메뉴 코드를 입력받는 메소드
    private static Map<String, String> inputMenuCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드 입력: ");
        String code = sc.nextLine();
        Map<String,String> param = new HashMap<>();
        param.put("code",code);

        return param;
    }

    // 메뉴 정보를 입력받는 메소드
    private static Map<String, String> inputMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명 입력: ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격 입력: ");
        String price = sc.nextLine();
        System.out.print("카테고리 코드 입력: ");
        String categoryCode = sc.nextLine();

        Map<String,String> param = new HashMap<>();
        param.put("name",name);
        param.put("price",price);
        param.put("categoryCode",categoryCode);

        return param;
    }

    private static Map<String, String> inputModifyMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴코드 입력: ");
        String code = sc.nextLine();
        System.out.print("수정할 메뉴명 입력: ");
        String name = sc.nextLine();
        System.out.print("수정할 메뉴 가격 입력: ");
        String price = sc.nextLine();
        System.out.print("수정할 카테고리 코드 입력: ");
        String categoryCode = sc.nextLine();

        Map<String,String> param = new HashMap<>();
        param.put("code",code);
        param.put("name",name);
        param.put("price",price);
        param.put("categoryCode",categoryCode);

        return param;
    }
}

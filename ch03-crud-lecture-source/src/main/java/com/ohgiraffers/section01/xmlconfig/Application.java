package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    /*
    * 시스템 요구사항
    *
    * 1. 메뉴 전체조회
    * 2. 메뉴 코드로 메뉴 조회
    * 3. 신규 메뉴 추가
    * 4. 메뉴 수정
    * 5. 메뉴 삭제
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        boolean flag = true;

        do{
            System.out.println("============== 메뉴 관리 시스템 ==============");
            System.out.println("1. 메뉴 전체조회\n" +
                    "2. 메뉴 코드로 메뉴 조회\n" +
                    "3. 신규 메뉴 추가\n" +
                    "4. 메뉴 수정\n" +
                    "5. 메뉴 삭제");
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
                    menuController.insertMenu();
                    break;
                case 4:
                    menuController.updateMenu();
                    break;
                case 5:
                    menuController.deleteMenu();
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
}

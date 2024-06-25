package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.MenuDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ElementTestService elementTestService = new ElementTestService();

        boolean flag = true;
        do {
            System.out.println("\n========== 매퍼 element 테스트 메뉴 ==========");
            System.out.println("1. <cache> 테스트\n2. <resultMap> 서브메뉴\n3. <sql> 테스트\n4. <insert> 서브메뉴\n0. 프로그램 종료");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: elementTestService.selectCacheTest(); break;
                case 2: resultMapSubMenu(); break;
                case 3: elementTestService.selectSqlTest(); break;
                case 4: insertSubMenu(); break;
                case 0: flag = false; break;
            }
        } while(flag);
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("\n========== <resultMap> 서브 메뉴 ==========");
            System.out.println("1. <resultMap> 테스트\n2. <constructor> 테스트\n3. <association> 테스트\n4. <collection> 테스트\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: elementTestService.selectResultMapTest(); break;
                case 2: elementTestService.selectResultMapConstructorTest(); break;
                case 3: elementTestService.selectResultMapAssociationTest(); break;
                case 4: elementTestService.selectResultMapCollectionTest(); break;
                case 0: return;
            }
        } while (true);
    }

    private static void insertSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();

        do {
            System.out.println("\n========== <insert> 서브 메뉴 ==========");
            System.out.println("1. <insert> 테스트 (메뉴 등록)\n2. <insert> 테스트 (신규 카테고리의 메뉴 등록)\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: elementTestService.insertMenuTest(inputMenu()); break;
//                case 2: elementTestService.(); break;
                case 0: return;
            }
        } while (true);
    }

    private static MenuDTO inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("등록할 메뉴 이름: ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격: ");
        int price = sc.nextInt();
        System.out.print("카테고리 코드: ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("판매 등록 여부 (Y/N): ");
        String orderableStatus = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);
        menu.setOrderableStatus(orderableStatus);

        return menu;
    }
}

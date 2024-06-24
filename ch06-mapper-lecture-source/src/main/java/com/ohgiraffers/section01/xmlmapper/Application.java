package com.ohgiraffers.section01.xmlmapper;

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
                case 3: break;
                case 4: break;
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
}

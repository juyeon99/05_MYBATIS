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
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            System.out.println("--------------------------------------------");

            switch (no){
                case 1: elementTestService.selectCacheTest(); break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 0: flag = false; break;
            }
        } while(flag);
    }
}

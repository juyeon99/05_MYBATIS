package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n========== MyBatis 동적 SQL (조건문) ==========");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("0. 종료하기");
            System.out.print("메뉴 선택: ");

            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: ifSubMenu(); break;
                case 2: chooseSubMenu(); break;
                case 3: break;
                case 4: break;
                case 0: System.out.println("시스템을 종료합니다."); return;
            }
        } while (true);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("\n========== if 서브메뉴 ==========");
            System.out.println("1. 원하는 금액대에 적합한 추천메뉴 목록 보여주기");
            System.out.println("2. 메뉴이름 또는 카테고리 명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("0. 이전 메뉴로");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1: menuService.selectMenuByPrice(inputPrice()); break;
                case 2: menuService.searchMenu(inputSearchCriteria()); break;
                case 0: return;
            }
        } while (true);
    }

    private static int inputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액 입력: ");
        int price = sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준 입력(name or category): ");
        String condition = sc.nextLine();
        System.out.print("검색어 입력: ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("\n========== choose 서브메뉴 ==========");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기 (식사, 음료, 디저트)");
            System.out.println("0. 이전 메뉴로");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1: menuService.searchMenuBySubCategory(inputSubCategory()); break;
                case 0: return;
            }
        } while (true);
    }

    private static SearchCriteria inputSubCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해주세요. (식사, 음료, 디저트): ");
        String value = sc.nextLine();

        return new SearchCriteria("category",value);
    }
}

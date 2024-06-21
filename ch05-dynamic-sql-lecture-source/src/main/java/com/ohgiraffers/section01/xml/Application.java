package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

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
                case 3: forEachSubMenu(); break;
                case 4: trimSubMenu(); break;
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

    private static void forEachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("\n========== foreach 서브메뉴 ==========");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("0. 이전 메뉴로");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1: menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList()); break;
                case 0: return;
            }
        } while (true);
    }

    private static List<Integer> createRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>(); // 중복제거 위해 Set 이용
        while (set.size() < 5){
            int temp = ((int) (Math.random() * 21)) + 1;    // 1 ~ 21
            set.add(temp);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("\n========== trim 서브메뉴 ==========");
            System.out.println("1. 검색 조건이 있는 경우 메뉴코드로 조회, 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색하며, 검색조건이 없는 경우 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("0. 이전 메뉴로");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1: menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
                case 2: menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3: menuService.modifyMenu(inputChangeInfo()); break;
                case 0: return;
            }
        } while (true);
    }

    private static SearchCriteria inputAllOrOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까?(예 or 아니오): ");
        boolean hasSearchValue = "예".equals(sc.nextLine()) ? true : false;
        SearchCriteria searchCriteria = new SearchCriteria();

        if (hasSearchValue){
            System.out.print("검색할 메뉴 코드를 입력하세요: ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;
    }

    private static Map<String, Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 조건 입력 (category / name / both / null): ");
        String condition = sc.nextLine();

        Map<String,Object> criteria = new HashMap<>();
        if ("category".equals(condition)){
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryValue = sc.nextInt();

            criteria.put("categoryValue", categoryValue);
        } else if ("name".equals(condition)){
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();

            criteria.put("nameValue", nameValue);
        } else if ("both".equals(condition)){
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryValue = sc.nextInt();

            criteria.put("nameValue", nameValue);
            criteria.put("categoryValue", categoryValue);
        }

        return criteria;
    }

    private static Map<String, Object> inputChangeInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 코드: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("변경할 메뉴 이름: ");
        String name = sc.nextLine();
        System.out.print("변경할 카테고리 코드: ");
        int categoryCode = sc.nextInt();
        sc.nextLine();
        System.out.print("판매 여부(Y/N): ");
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("code", code);
        criteria.put("name", name);
        criteria.put("categoryCode", categoryCode);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;
    }
}

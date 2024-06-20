package com.ohgiraffers.section02.javaconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final PrintResult printResult;
    private final MenuService menuService;

    // constructor 주입
    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    // 전체 조회
    public void selectAllMenu(){
        List<MenuDTO> menuList = menuService.selectAllMenu();

        // view로 전달
        if (menuList != null){
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> param) {
        int code = Integer.parseInt(param.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registerMenu(Map<String, String> param) {
        String name = param.get("name");
        int price = Integer.parseInt(param.get("price"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        boolean result = menuService.registerMenu(menu);

        if (result){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(Map<String, String> param) {
        int code = Integer.parseInt(param.get("code"));
        String name = param.get("name");
        int price = Integer.parseInt(param.get("price"));
        int categoryCode = Integer.parseInt(param.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        boolean result = menuService.modifyMenu(menu);

        if (result){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> param) {
        int code = Integer.parseInt(param.get("code"));

        boolean result = menuService.deleteMenu(code);

        if (result){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }
}

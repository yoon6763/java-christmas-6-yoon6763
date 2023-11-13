package christmas.valid;

import christmas.models.RestaurantMenu;

import java.util.HashMap;

public class MenuValidator extends Validator {

    public static HashMap<RestaurantMenu, Integer> menuValidate(String menuInput) throws IllegalArgumentException {
        HashMap<RestaurantMenu, Integer> menuAndCount = new HashMap<>();

        String[] userMenu = menuInput.split(",");
        for (String menu : userMenu) {
            String[] menuAndCountArray = menu.split("-");

            RestaurantMenu restaurantMenu = findMenu(menuAndCountArray[0]);
            int menuCount = convertToInteger(menuAndCountArray[1]);

            checkDuplicatedMenu(menuAndCount, restaurantMenu);

            menuAndCount.put(restaurantMenu, menuCount);
        }

        return menuAndCount;
    }

    private static void checkDuplicatedMenu(HashMap<RestaurantMenu, Integer> menuAndCount, RestaurantMenu restaurantMenu) {
        if (menuAndCount.containsKey(restaurantMenu)) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다.");
        }
    }

    private static RestaurantMenu findMenu(String menuTitle) {
        for (RestaurantMenu menu : RestaurantMenu.values()) {
            if (menu.getMenuTitle().equals(menuTitle)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
    }

}

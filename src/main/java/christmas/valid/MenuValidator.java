package christmas.valid;

import christmas.models.menu.Category;
import christmas.models.menu.RestaurantMenu;

import java.util.HashMap;

public class MenuValidator extends Validator {

    private final static int MAX_MENU_COUNT = 20;

    public static HashMap<RestaurantMenu, Integer> menuValidate(String menuInput) throws IllegalArgumentException {
        HashMap<RestaurantMenu, Integer> menuAndCount = new HashMap<>();

        stockMenu(menuInput, menuAndCount);

        checkMenuCountOverMax(menuAndCount);
        checkContainsNonDrink(menuAndCount);

        return menuAndCount;
    }

    private static void stockMenu(String menuInput, HashMap<RestaurantMenu, Integer> menuAndCount) {
        String[] userMenu = menuInput.split(",");
        for (String menu : userMenu) {
            String[] menuAndCountArray = menu.split("-");

            RestaurantMenu restaurantMenu = findMenu(menuAndCountArray[0]);
            int menuCount = convertToInteger(menuAndCountArray[1]);

            checkDuplicatedMenu(menuAndCount, restaurantMenu);

            menuAndCount.put(restaurantMenu, menuCount);
        }
    }

    private static void checkContainsNonDrink(HashMap<RestaurantMenu, Integer> menuAndCount) {
        for (RestaurantMenu menu : menuAndCount.keySet()) {
            if (menu.getCategory() != Category.DRINK) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
    }

    private static void checkMenuCountOverMax(HashMap<RestaurantMenu, Integer> menuAndCount) {
        int totalMenuCount = menuAndCount.values().stream().mapToInt(Integer::intValue).sum();
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 20개까지만 가능합니다.");
        }
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

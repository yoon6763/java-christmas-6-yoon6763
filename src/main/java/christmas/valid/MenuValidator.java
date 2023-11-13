package christmas.valid;

import christmas.models.menu.Category;
import christmas.models.menu.RestaurantMenu;

import java.util.HashMap;

public class MenuValidator {

    private final static int MAX_MENU_COUNT = 20;

    public static HashMap<RestaurantMenu, Integer> menuValidate(String menuInput) throws IllegalArgumentException {
        HashMap<RestaurantMenu, Integer> menuAndCount = new HashMap<>();

        stockMenu(menuInput, menuAndCount);

        checkMenuCountOverMax(menuAndCount);
        checkContainsNonDrink(menuAndCount);

        return menuAndCount;
    }

    private static void stockMenu(String menuInput, HashMap<RestaurantMenu, Integer> menuAndCount) throws IllegalArgumentException {
        try {
            String[] userMenu = menuInput.split(",");
            for (String menu : userMenu) {
                String[] menuAndCountArray = menu.split("-");

                RestaurantMenu restaurantMenu = findMenu(menuAndCountArray[0]);
                int menuCount = Integer.parseInt(menuAndCountArray[1]);

                checkDuplicatedMenu(menuAndCount, restaurantMenu);

                menuAndCount.put(restaurantMenu, menuCount);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkContainsNonDrink(HashMap<RestaurantMenu, Integer> menuAndCount) throws IllegalArgumentException {
        for (RestaurantMenu menu : menuAndCount.keySet()) {
            if (menu.getCategory() != Category.DRINK) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static void checkMenuCountOverMax(HashMap<RestaurantMenu, Integer> menuAndCount) throws IllegalArgumentException {
        int totalMenuCount = menuAndCount.values().stream().mapToInt(Integer::intValue).sum();
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void checkDuplicatedMenu(HashMap<RestaurantMenu, Integer> menuAndCount, RestaurantMenu restaurantMenu) throws IllegalArgumentException {
        if (menuAndCount.containsKey(restaurantMenu)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static RestaurantMenu findMenu(String menuTitle) throws IllegalArgumentException {
        for (RestaurantMenu menu : RestaurantMenu.values()) {
            if (menu.getMenuTitle().equals(menuTitle)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}

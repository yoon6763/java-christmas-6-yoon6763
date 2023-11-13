package christmas.models.gift;

import christmas.models.menu.RestaurantMenu;

public class Gift {
    private final RestaurantMenu menu;
    private final int giftCount;

    public Gift(RestaurantMenu menu, int giftCount) {
        this.menu = menu;
        this.giftCount = giftCount;
    }

    public RestaurantMenu getMenu() {
        return menu;
    }

    public int getGiftCount() {
        return giftCount;
    }
}

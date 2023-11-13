package christmas.models;

import christmas.models.discount.Discount;
import christmas.models.gift.Gift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Plan {
    private final HashMap<RestaurantMenu, Integer> menu;
    private final List<Discount> discounts = new ArrayList<>();
    private final List<Gift> gifts = new ArrayList<>();

    public Plan(HashMap<RestaurantMenu, Integer> menu) {
        this.menu = menu;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public HashMap<RestaurantMenu, Integer> getMenu() {
        return menu;
    }
}

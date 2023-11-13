package christmas.models;

import christmas.models.discount.Discount;
import christmas.models.gift.Gift;
import christmas.models.menu.RestaurantMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Plan {

    private final HashMap<RestaurantMenu, Integer> menu;
    private final List<Discount> discounts = new ArrayList<>();
    private final List<Gift> gifts = new ArrayList<>();
    private final Badge badge;

    public Plan(HashMap<RestaurantMenu, Integer> menu) {
        this.menu = menu;
        this.badge = Badge.of(calcEventPrice());
    }

    public int calcTotalPrice() {
        return menu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int calcDiscountPrice() {
        return discounts.stream()
                .mapToInt(Discount::getDiscountPrice)
                .sum();
    }

    public int calcGiftPrice() {
        return gifts.stream()
                .mapToInt(gift -> gift.getGiftCount() * gift.getMenu().getPrice())
                .sum();
    }

    public int calcEventPrice() {
        int discountPrice = calcDiscountPrice();
        int giftPrice = calcGiftPrice();

        return discountPrice + giftPrice;
    }

    public int calcFinalPrice() {
        return calcTotalPrice() - calcDiscountPrice();
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

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public Badge getBadge() {
        return badge;
    }
}

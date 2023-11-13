package christmas;

import christmas.event.discount.DiscountConfig;
import christmas.event.discount.DiscountPolicy;
import christmas.event.gift.GiftPolicy;
import christmas.models.Plan;
import christmas.models.RestaurantMenu;
import christmas.models.gift.GiftConfig;

import java.util.HashMap;
import java.util.List;

public class EventPlanCalculator {

    public Plan calculate(HashMap<RestaurantMenu, Integer> menu, int visitDate) {
        Plan result = new Plan(menu);

        applyDiscountPolicy(menu, visitDate, result);
        applyGiftPolicy(menu, result);

        return result;
    }

    private static void applyGiftPolicy(HashMap<RestaurantMenu, Integer> menu, Plan result) {
        List<GiftPolicy> giftPolicies = GiftConfig.getGiftPolicies();
        for (GiftPolicy giftPolicy : giftPolicies) {
            giftPolicy.applyGift(menu).ifPresent(result::addGift);
        }
    }

    private static void applyDiscountPolicy(HashMap<RestaurantMenu, Integer> menu, int visitDate, Plan result) {
        List<DiscountPolicy> discountPolicies = DiscountConfig.getDiscountPolicies();

        for (DiscountPolicy discountPolicy : discountPolicies) {
            discountPolicy.applyDiscount(menu, visitDate).ifPresent(result::addDiscount);
        }
    }

}

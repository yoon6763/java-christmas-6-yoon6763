package christmas;

import christmas.eventpolicy.DiscountConfig;
import christmas.eventpolicy.discount.DiscountPolicy;
import christmas.eventpolicy.gift.GiftPolicy;
import christmas.models.Plan;
import christmas.models.menu.RestaurantMenu;
import christmas.eventpolicy.GiftConfig;

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

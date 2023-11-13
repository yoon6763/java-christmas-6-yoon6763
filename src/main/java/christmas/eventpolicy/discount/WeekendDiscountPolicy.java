package christmas.eventpolicy.discount;

import christmas.models.Category;
import christmas.models.RestaurantMenu;
import christmas.models.discount.Discount;
import christmas.models.discount.DiscountType;
import christmas.utils.EventDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private static final int WEEKEND_DISCOUNT_PRICE = 2023;

    @Override
    public Optional<Discount> applyDiscount(HashMap<RestaurantMenu, Integer> menuResult, int visitDate) {
        if (!EventDate.isWeekend(visitDate)) {
            return Optional.empty();
        }

        int amount = calcDiscount(menuResult);

        if (amount == 0) {
            return Optional.empty();
        }

        return Optional.of(new Discount(DiscountType.WEEKEND_DISCOUNT, amount * WEEKEND_DISCOUNT_PRICE));
    }

    private static int calcDiscount(HashMap<RestaurantMenu, Integer> menuResult) {
        int amount = 0;

        for (Map.Entry<RestaurantMenu, Integer> entry : menuResult.entrySet()) {
            RestaurantMenu menu = entry.getKey();
            int count = entry.getValue();

            if (menu.getCategory() == Category.MAIN) {
                amount += count;
            }
        }

        return amount;
    }
}

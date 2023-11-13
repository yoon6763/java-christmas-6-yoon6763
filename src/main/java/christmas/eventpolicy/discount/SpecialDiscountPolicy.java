package christmas.eventpolicy.discount;

import christmas.models.menu.RestaurantMenu;
import christmas.models.discount.Discount;
import christmas.models.discount.DiscountType;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private static final List<Integer> SPECIAL_DISCOUNT_DATES = List.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;

    @Override
    public Optional<Discount> applyDiscount(HashMap<RestaurantMenu, Integer> menuResult, int visitDate) {
        if (!SPECIAL_DISCOUNT_DATES.contains(visitDate)) {
            return Optional.empty();
        }

        return Optional.of(new Discount(DiscountType.SPECIAL_DISCOUNT, SPECIAL_DISCOUNT_PRICE));
    }
}

package christmas.eventpolicy.discount;

import christmas.models.RestaurantMenu;
import christmas.models.discount.Discount;
import christmas.models.discount.DiscountType;

import java.util.HashMap;
import java.util.Optional;

public class ChristmasDiscountPolicy implements DiscountPolicy {

    @Override
    public Optional<Discount> applyDiscount(HashMap<RestaurantMenu, Integer> menuResult, int visitDate) {

        if (visitDate > 25) {
            return Optional.empty();
        }

        int discountPrice = calcDiscount(visitDate);
        return Optional.of(new Discount(DiscountType.CHRISTMAS_DISCOUNT, discountPrice));
    }

    private static int calcDiscount(int visitDate) {
        return 1000 + (visitDate - 1) * 100;
    }
}

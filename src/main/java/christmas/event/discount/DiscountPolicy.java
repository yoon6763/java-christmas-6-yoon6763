package christmas.event.discount;

import christmas.models.RestaurantMenu;
import christmas.models.discount.Discount;

import java.util.HashMap;
import java.util.Optional;

public interface DiscountPolicy {

    Optional<Discount> applyDiscount(HashMap<RestaurantMenu, Integer> menuResult, int visitDate);

}
package christmas.event.gift;

import christmas.models.RestaurantMenu;
import christmas.models.discount.Discount;
import christmas.models.gift.Gift;

import java.util.HashMap;
import java.util.Optional;

public interface GiftPolicy {

    Optional<Gift> applyGift(HashMap<RestaurantMenu, Integer> menuResult);

}

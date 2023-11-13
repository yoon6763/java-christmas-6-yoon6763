package christmas.eventpolicy.gift;

import christmas.models.RestaurantMenu;
import christmas.models.gift.Gift;

import java.util.HashMap;
import java.util.Optional;

public class ChampagneGiftPolicy implements GiftPolicy {

    private static final int CHAMPAGNE_GIFT_PRICE = 120000;

    @Override
    public Optional<Gift> applyGift(HashMap<RestaurantMenu, Integer> menuResult) {
        int totalPrice = getTotalPrice(menuResult);

        if (totalPrice < CHAMPAGNE_GIFT_PRICE) {
            return Optional.empty();
        }

        return Optional.of(new Gift(RestaurantMenu.CHAMPAGNE, 1));
    }

    private static int getTotalPrice(HashMap<RestaurantMenu, Integer> menuResult) {
        return menuResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}

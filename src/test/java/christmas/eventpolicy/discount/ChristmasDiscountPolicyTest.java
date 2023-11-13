package christmas.eventpolicy.discount;

import christmas.models.discount.Discount;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountPolicyTest {

    ChristmasDiscountPolicy christmasDiscountPolicy = new ChristmasDiscountPolicy();

    HashMap<RestaurantMenu, Integer> sampleMenu() {
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.CHRISTMAS_PASTA, 1);
        return menu;
    }

    @Test
    void 방문_1일() {
        // given
        int visitDate = 1;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = christmasDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1000, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_3일() {
        // given
        int visitDate = 3;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = christmasDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1200, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_25일() {
        // given
        int visitDate = 25;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = christmasDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(3400, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_26일_헤택없음() {
        // given
        int visitDate = 26;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = christmasDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertFalse(discount.isPresent());
    }

}
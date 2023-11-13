package christmas.eventpolicy.discount;

import christmas.models.discount.Discount;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountPolicyTest {

    SpecialDiscountPolicy specialDiscountPolicy = new SpecialDiscountPolicy();

    HashMap<RestaurantMenu, Integer> sampleMenu() {
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.CHRISTMAS_PASTA, 1);
        return menu;
    }

    @Test
    void 방문_3일_특별() {
        // given
        int visitDate = 3;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1000, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_25일_특별() {
        // given
        int visitDate = 25;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1000, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_10일_특별() {
        // given
        int visitDate = 10;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1000, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_17일_특별() {
        // given
        int visitDate = 17;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(1000, discount.get().getDiscountPrice());
    }

    @Test
    void 방문_13일_안특별() {
        // given
        int visitDate = 13;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertFalse(discount.isPresent());
    }

    @Test
    void 방문_22일_안특별() {
        // given
        int visitDate = 22;
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();

        // when
        Optional<Discount> discount = specialDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertFalse(discount.isPresent());
    }

}
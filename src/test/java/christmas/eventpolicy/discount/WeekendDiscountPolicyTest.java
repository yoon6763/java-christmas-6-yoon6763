package christmas.eventpolicy.discount;

import christmas.models.discount.Discount;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WeekendDiscountPolicyTest {
    /*
        주말 할인 : 주말에는 메인 메뉴를 1개당 2,023원 할인
     */

    WeekendDiscountPolicy weekdayDiscountPolicy = new WeekendDiscountPolicy();

    HashMap<RestaurantMenu, Integer> sampleMenu() {
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.ICE_CREAM, 1);
        menu.put(RestaurantMenu.RED_WINE, 1);
        menu.put(RestaurantMenu.CAESAR_SALAD, 1);
        return menu;
    }

    @Test
    void 메인메뉴_1개() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 9;
        menu.put(RestaurantMenu.BBQ_RIB, 1);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(2023, discount.get().getDiscountPrice());
    }

    @Test
    void 메인메뉴_2개() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 9;
        menu.put(RestaurantMenu.BBQ_RIB, 2);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(4046, discount.get().getDiscountPrice());
    }

    @Test
    void 메인메뉴_다른_종류() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 9;
        menu.put(RestaurantMenu.CHRISTMAS_PASTA, 1);
        menu.put(RestaurantMenu.BBQ_RIB, 1);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(2023 * 2, discount.get().getDiscountPrice());
    }

    @Test
    void 주말_헤택없음() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 10;
        menu.put(RestaurantMenu.BBQ_RIB, 1);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertFalse(discount.isPresent());
    }

}
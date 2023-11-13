package christmas.eventpolicy.discount;

import christmas.models.discount.Discount;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayDiscountPolicyTest {

    /*
        평일 할인 : 평일에는 디저트 메뉴를 1개당 2,023원 할인
     */

    WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy();

    HashMap<RestaurantMenu, Integer> sampleMenu() {
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.CHRISTMAS_PASTA, 1);
        menu.put(RestaurantMenu.BBQ_RIB, 1);
        menu.put(RestaurantMenu.RED_WINE, 1);
        return menu;
    }


    @Test
    void 디저트_1개() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 12;
        menu.put(RestaurantMenu.CHOCOLATE_CAKE, 1);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(2023, discount.get().getDiscountPrice());
    }

    @Test
    void 디저트_2개() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 12;
        menu.put(RestaurantMenu.CHOCOLATE_CAKE, 2);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(4046, discount.get().getDiscountPrice());
    }

    @Test
    void 디저트_다른_종류() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 12;
        menu.put(RestaurantMenu.CHOCOLATE_CAKE, 1);
        menu.put(RestaurantMenu.ICE_CREAM, 1);

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertTrue(discount.isPresent());
        assertEquals(4046, discount.get().getDiscountPrice());
    }

    @Test
    void 주말_헤택없음() {
        // given
        HashMap<RestaurantMenu, Integer> menu = sampleMenu();
        int visitDate = 11;

        // when
        Optional<Discount> discount = weekdayDiscountPolicy.applyDiscount(menu, visitDate);

        // then
        assertFalse(discount.isPresent());
    }

}
package christmas.models;

import christmas.eventpolicy.DiscountConfig;
import christmas.eventpolicy.GiftConfig;
import christmas.models.discount.Discount;
import christmas.models.gift.Gift;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlanTest {

    /*
        주말 할인 : 주말에는 메인 메뉴를 1개당 2,023원 할인
        평일 할인 : 평일에는 디저트 메뉴를 1개당 2,023원 할인
        특별 할인 : 특별한 날에는 총 주문 금엑에서 1,000원 할인
        크리스마스 디데이 : 1일 부터 1,000원 부터 하루에 100원씩 할인

        증정품 : 12만원 이상 주문시 샴페인 1병 증정
     */


    void applyDiscountAndGiftPolicy(Plan plan, HashMap<RestaurantMenu, Integer> menu, int visitDate) {
        DiscountConfig.getDiscountPolicies().forEach(discountPolicy -> {
            Optional<Discount> discount = discountPolicy.applyDiscount(menu, visitDate);
            discount.ifPresent(plan::addDiscount);
        });

        GiftConfig.getGiftPolicies().forEach(giftPolicy -> {
            Optional<Gift> gift = giftPolicy.applyGift(menu);
            gift.ifPresent(plan::addGift);
        });
    }

    @Test
    void 플랜_1() {
        // given
        int visitDate = 12;
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.CHRISTMAS_PASTA, 1); // 25,000
        menu.put(RestaurantMenu.ICE_CREAM, 1); // 5,000
        menu.put(RestaurantMenu.RED_WINE, 2); // 60,000 * 2 = 120,000

        Plan plan = new Plan(menu);

        int totalPrice = menu.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();

        int calcDiscountPrice = DiscountConfig.getDiscountPolicies()
                .stream()
                .mapToInt(discountPolicy -> {
                    Optional<Discount> discount = discountPolicy.applyDiscount(menu, visitDate);
                    return discount.map(Discount::getDiscountPrice).orElse(0);
                }).sum();


        // when
        applyDiscountAndGiftPolicy(plan, menu, visitDate);

        // then
        assertEquals(totalPrice, plan.calcTotalPrice());
        assertEquals(calcDiscountPrice, plan.calcDiscountPrice());
        assertEquals(RestaurantMenu.CHAMPAGNE.getPrice(), plan.calcGiftPrice());
        assertEquals(calcDiscountPrice + RestaurantMenu.CHAMPAGNE.getPrice(), plan.calcEventPrice());
        assertEquals(totalPrice - calcDiscountPrice, plan.calcFinalPrice());
    }

    @Test
    void 플랜_2() {
        // given
        int visitDate = 31;
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.BBQ_RIB, 3);
        menu.put(RestaurantMenu.ICE_CREAM, 12); // 5,000
        menu.put(RestaurantMenu.SEAFOOD_PASTA, 1); // 25,000

        Plan plan = new Plan(menu);

        int totalPrice = menu.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();

        int calcDiscountPrice = DiscountConfig.getDiscountPolicies()
                .stream()
                .mapToInt(discountPolicy -> {
                    Optional<Discount> discount = discountPolicy.applyDiscount(menu, visitDate);
                    return discount.map(Discount::getDiscountPrice).orElse(0);
                }).sum();

        // when
        applyDiscountAndGiftPolicy(plan, menu, visitDate);

        // then
        assertEquals(totalPrice, plan.calcTotalPrice());
        assertEquals(calcDiscountPrice, plan.calcDiscountPrice());
        assertEquals(RestaurantMenu.CHAMPAGNE.getPrice(), plan.calcGiftPrice());
        assertEquals(calcDiscountPrice + RestaurantMenu.CHAMPAGNE.getPrice(), plan.calcEventPrice());
        assertEquals(totalPrice - calcDiscountPrice, plan.calcFinalPrice());
    }

    @Test
    void 플랜_3_샴페인_없음() {
        // given
        int visitDate = 31;
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.BBQ_RIB, 1);

        Plan plan = new Plan(menu);

        int totalPrice = menu.entrySet().stream().mapToInt(entry -> entry.getKey().getPrice() * entry.getValue()).sum();

        int calcDiscountPrice = DiscountConfig.getDiscountPolicies()
                .stream()
                .mapToInt(discountPolicy -> {
                    Optional<Discount> discount = discountPolicy.applyDiscount(menu, visitDate);
                    return discount.map(Discount::getDiscountPrice).orElse(0);
                }).sum();

        // when
        applyDiscountAndGiftPolicy(plan, menu, visitDate);

        // then
        assertEquals(totalPrice, plan.calcTotalPrice());
        assertEquals(calcDiscountPrice, plan.calcDiscountPrice());
        assertEquals(0, plan.calcGiftPrice());
        assertEquals(calcDiscountPrice, plan.calcEventPrice());
        assertEquals(totalPrice - calcDiscountPrice, plan.calcFinalPrice());
    }

}
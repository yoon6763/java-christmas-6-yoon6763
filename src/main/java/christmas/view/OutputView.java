package christmas.view;

import christmas.models.Badge;
import christmas.models.discount.Discount;
import christmas.models.gift.Gift;
import christmas.models.menu.RestaurantMenu;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    private final static String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final static String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private final static String BEFORE_DISCOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private final static String GIFT_MENU_MESSAGE = "<증정 메뉴>";
    private final static String DISCOUNT_CONTENT_MESSAGE = "<혜택 내역>";
    private final static String ALL_EVENT_PRICE_MESSAGE = "<총혜택 금액>";
    private final static String AFTER_DISCOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private final static String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";

    private void printEmptyLine() {
        System.out.println();
    }

    public void printPreviewMessage(int visitDate) {
        System.out.println(String.format(PREVIEW_MESSAGE, visitDate));
        printEmptyLine();
    }

    public void printOrderMenuMessage(HashMap<RestaurantMenu, Integer> menu) {
        System.out.println(ORDER_MENU_MESSAGE);

        for (RestaurantMenu restaurantMenu : menu.keySet()) {
            System.out.println(restaurantMenu.getMenuTitle() + " " + menu.get(restaurantMenu) + "개");
        }
        printEmptyLine();
    }

    public void printBeforeDiscountMessage(int totalPrice) {
        System.out.println(BEFORE_DISCOUNT_MESSAGE);
        System.out.println(moneyFormat(totalPrice) + "원");
        printEmptyLine();
    }

    public void printGiftMenuMessage(List<Gift> gifts) {
        System.out.println(GIFT_MENU_MESSAGE);
        for (Gift gift : gifts) {
            System.out.println(gift.getMenu().getMenuTitle() + " " + gift.getGiftCount() + "개");
        }
        printEmptyLine();
    }

    public void printDiscountContentMessage(List<Discount> discounts, List<Gift> gifts) {
        System.out.println(DISCOUNT_CONTENT_MESSAGE);
        for (Discount discount : discounts) {
            System.out.println(discount.getDiscountType().getName() + ": -" + moneyFormat(discount.getDiscountPrice()) + "원");
        }

        for (Gift gift : gifts) {
            System.out.println("증정 이벤트: -" + moneyFormat(gift.getMenu().getPrice()) + "원");
        }
        printEmptyLine();
    }

    public void printAllEventPriceMessage(int eventPrice) {
        System.out.println(ALL_EVENT_PRICE_MESSAGE);
        System.out.println("-" + moneyFormat(eventPrice) + "원");
        printEmptyLine();
    }

    public void printAfterDiscountMessage(int finalPrice) {
        System.out.println(AFTER_DISCOUNT_MESSAGE);
        System.out.println(moneyFormat(finalPrice) + "원");
        printEmptyLine();
    }

    public void printEventBadgeMessage(Badge badge) {
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.println(badge.getBadgeName());
    }


    private String moneyFormat(int price) {
        return String.format("%,d", price);
    }

}

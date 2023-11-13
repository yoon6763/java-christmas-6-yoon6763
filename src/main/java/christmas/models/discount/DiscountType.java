package christmas.models.discount;

public enum DiscountType {

    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    SPECIAL_DISCOUNT("특별 할인");

    final String name;

    DiscountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

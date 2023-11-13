package christmas.models.gift;

public enum GiftType {

    CHAMPAGNE("샴페인", 100000);

    GiftType(String giftName, int price) {
        this.giftName = giftName;
        this.price = price;
    }

    final String giftName;
    final int price;
}

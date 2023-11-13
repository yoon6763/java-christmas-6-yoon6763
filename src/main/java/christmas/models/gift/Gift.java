package christmas.models.gift;

public class Gift {
    private final GiftType giftType;
    private final int giftCount;

    public Gift(GiftType giftType, int giftCount) {
        this.giftType = giftType;
        this.giftCount = giftCount;
    }

    public GiftType getGiftType() {
        return giftType;
    }

    public int getGiftCount() {
        return giftCount;
    }
}

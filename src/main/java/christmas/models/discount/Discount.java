package christmas.models.discount;

public class Discount {

    private final DiscountType discountType;
    private final int discountPrice;

    public Discount(DiscountType discountType, int discountPrice) {
        this.discountType = discountType;
        this.discountPrice = discountPrice;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}

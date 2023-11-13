package christmas.eventpolicy;

import christmas.eventpolicy.discount.*;

import java.util.List;

public class DiscountConfig {

    private static final List<DiscountPolicy> DISCOUNT_POLICIES = List.of(
            new WeekdayDiscountPolicy(),
            new WeekendDiscountPolicy(),
            new SpecialDiscountPolicy(),
            new ChristmasDiscountPolicy()
    );

    public static List<DiscountPolicy> getDiscountPolicies() {
        return DISCOUNT_POLICIES;
    }
}

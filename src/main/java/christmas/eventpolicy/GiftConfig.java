package christmas.eventpolicy;

import christmas.eventpolicy.gift.ChampagneGiftPolicy;
import christmas.eventpolicy.gift.GiftPolicy;

import java.util.List;

public class GiftConfig {

    private static final List<GiftPolicy> giftPolicies = List.of(
            new ChampagneGiftPolicy()
    );

    public static List<GiftPolicy> getGiftPolicies() {
        return giftPolicies;
    }

}

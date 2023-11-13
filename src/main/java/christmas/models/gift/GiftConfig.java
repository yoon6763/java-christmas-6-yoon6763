package christmas.models.gift;

import christmas.event.gift.ChampagneGiftPolicy;
import christmas.event.gift.GiftPolicy;

import java.util.List;

public class GiftConfig {

    private static final List<GiftPolicy> giftPolicies = List.of(
            new ChampagneGiftPolicy()
    );

    public static List<GiftPolicy> getGiftPolicies() {
        return giftPolicies;
    }

}

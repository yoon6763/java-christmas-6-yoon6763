package christmas.eventpolicy.gift;

import christmas.models.gift.Gift;
import christmas.models.menu.RestaurantMenu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChampagneGiftPolicyTest {

    ChampagneGiftPolicy champagneGiftPolicy = new ChampagneGiftPolicy();

    @Test
    void _120000원_이상_구매() {
        // given
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.T_BONE_STEAK, 15);

        // when
        Optional<Gift> gift = champagneGiftPolicy.applyGift(menu);

        // then
        assertTrue(gift.isPresent());
        assertEquals(RestaurantMenu.CHAMPAGNE, gift.get().getMenu());
    }

    @Test
    void _120000원_미만_구매() {
        // given
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.T_BONE_STEAK, 1);

        // when
        Optional<Gift> gift = champagneGiftPolicy.applyGift(menu);

        // then
        assertFalse(gift.isPresent());
    }

    @Test
    void _120000원_구매() {
        // given
        HashMap<RestaurantMenu, Integer> menu = new HashMap<>();
        menu.put(RestaurantMenu.T_BONE_STEAK, 2); // 55000 * 2 = 110000
        menu.put(RestaurantMenu.ICE_CREAM, 2); // 5000 * 2 = 10000

        // when
        Optional<Gift> gift = champagneGiftPolicy.applyGift(menu);

        // then
        assertTrue(gift.isPresent());
        assertEquals(RestaurantMenu.CHAMPAGNE, gift.get().getMenu());
    }

}
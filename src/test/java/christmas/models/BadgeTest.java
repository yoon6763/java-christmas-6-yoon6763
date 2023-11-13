package christmas.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @Test
    void 배지_산타() {
        // given
        int price = 100000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.SANTA, badge);
    }

    @Test
    void 배지_산타_2() {
        // given
        int price = 20000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.SANTA, badge);
    }

    @Test
    void 배지_트리() {
        // given
        int price = 10000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.TREE, badge);
    }

    @Test
    void 배지_트리_2() {
        // given
        int price = 15000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.TREE, badge);
    }

    @Test
    void 배지_별() {
        // given
        int price = 5000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.STAR, badge);
    }

    @Test
    void 배지_별_2() {
        // given
        int price = 7000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.STAR, badge);
    }

    @Test
    void 배지_없음() {
        // given
        int price = 1000;

        // when
        Badge badge = Badge.of(price);

        // then
        assertEquals(Badge.NONE, badge);
    }

}
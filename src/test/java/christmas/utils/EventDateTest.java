package christmas.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDateTest {

    /*
        문제에서 명시된 주말은 금, 토
        문제에서 명시된 평일은 일 ~ 목
     */

    @Test
    void 주말() {
        // given
        int date = 9;

        // when
        boolean isWeekend = EventDate.isWeekend(date);

        // then
        assertTrue(isWeekend);
    }

    @Test
    void 평일() {
        // given
        int date = 12;

        // when
        boolean isWeekend = EventDate.isWeekend(date);

        // then
        assertFalse(isWeekend);
    }

    @Test
    void 주말_2() {
        // given
        int date = 15;

        // when
        boolean isWeekend = EventDate.isWeekend(date);

        // then
        assertTrue(isWeekend);
    }

    @Test
    void 평일_2() {
        // given
        int date = 11;

        // when
        boolean isWeekend = EventDate.isWeekend(date);

        // then
        assertFalse(isWeekend);
    }

}
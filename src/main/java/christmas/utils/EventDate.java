package christmas.utils;

import java.time.LocalDate;

public class EventDate {

    private static LocalDate getDate(int visitedDate) {
        return LocalDate.of(2023, 12, visitedDate);
    }

    public static boolean isWeekend(int visitedDate) {
        LocalDate localDate = getDate(visitedDate);
        return localDate.getDayOfWeek().getValue() == 5 || localDate.getDayOfWeek().getValue() == 6;
    }

    public static boolean isWeekday(int visitedDate) {
        return !isWeekend(visitedDate);
    }

}

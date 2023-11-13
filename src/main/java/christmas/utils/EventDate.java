package christmas.utils;

import java.time.LocalDate;

public class EventDate {

    private final static int YEAR = 2023;
    private final static int MONTH = 12;

    private static LocalDate getDate(int visitedDate) {
        return LocalDate.of(YEAR, MONTH, visitedDate);
    }

    public static boolean isWeekend(int visitedDate) {
        LocalDate localDate = getDate(visitedDate);
        return localDate.getDayOfWeek().getValue() == 5 || localDate.getDayOfWeek().getValue() == 6;
    }

    public static boolean isWeekday(int visitedDate) {
        return !isWeekend(visitedDate);
    }

}

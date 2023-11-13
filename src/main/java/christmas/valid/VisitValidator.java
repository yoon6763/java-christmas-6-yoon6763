package christmas.valid;

public class VisitValidator {

    private final static String VISIT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static int validateVisitDate(String visitDay) throws IllegalArgumentException {
        try {
            int visitDate = Integer.parseInt(visitDay);
            isValidDateRange(visitDate);
            return visitDate;
        } catch (Exception e) {
            throw new IllegalArgumentException(VISIT_ERROR_MESSAGE);
        }
    }

    private static void isValidDateRange(int date) throws IllegalArgumentException {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(VISIT_ERROR_MESSAGE);
        }
    }
}

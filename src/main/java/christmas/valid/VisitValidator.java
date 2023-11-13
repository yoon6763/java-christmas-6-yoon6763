package christmas.valid;

public class VisitValidator {

    public static int validateVisitDate(String visitDay) throws IllegalArgumentException {
        try {
            int visitDate = Integer.parseInt(visitDay);
            isValidDateRange(visitDate);
            return visitDate;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void isValidDateRange(int date) throws IllegalArgumentException {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}

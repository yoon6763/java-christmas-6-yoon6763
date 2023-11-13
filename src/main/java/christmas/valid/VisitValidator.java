package christmas.valid;

public class VisitValidator extends Validator {

    public static int validateVisitDate(String visitDay) throws IllegalArgumentException {
        int visitDate = convertToInteger(visitDay);
        isValidDateRange(visitDate);
        return visitDate;
    }

    private static void isValidDateRange(int date) throws IllegalArgumentException {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 1~31 사이의 숫자를 입력해주세요.");
        }
    }
}

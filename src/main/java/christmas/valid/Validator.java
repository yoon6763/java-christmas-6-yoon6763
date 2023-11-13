package christmas.valid;

public class Validator {

    protected static int convertToInteger(String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

}

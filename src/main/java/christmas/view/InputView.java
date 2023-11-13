package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.models.RestaurantMenu;
import christmas.valid.MenuValidator;
import christmas.valid.VisitValidator;

import java.util.HashMap;

public class InputView {

    private final static String INPUT_VISIT_DATE_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private final static String INPUT_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int inputVisitDate() {
        while (true) {
            System.out.println(INPUT_VISIT_DATE_MESSAGE);

            try {
                String visitDay = Console.readLine();
                return VisitValidator.validateVisitDate(visitDay);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public HashMap<RestaurantMenu, Integer> inputMenu() {
        while (true) {
            System.out.println(INPUT_MENU_MESSAGE);

            try {
                return MenuValidator.menuValidate(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
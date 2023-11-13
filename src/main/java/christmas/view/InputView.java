package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.valid.VisitValidator;

public class InputView {

    public int inputVisitDate() {
        String visitDay = Console.readLine();
        return VisitValidator.validateVisitDate(visitDay);
    }

}
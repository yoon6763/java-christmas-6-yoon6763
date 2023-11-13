package christmas;

import christmas.models.Plan;
import christmas.models.menu.RestaurantMenu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventPlanner {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final EventPlanCalculator eventPlanCalculator = new EventPlanCalculator();

    public void start() {
        int visitDate = inputView.inputVisitDate();
        HashMap<RestaurantMenu, Integer> menu = inputView.inputMenu();

        Plan plan = eventPlanCalculator.calculate(menu, visitDate);

        printPlan(plan, visitDate);
    }

    private void printPlan(Plan plan, int visitDate) {
        outputView.printPreviewMessage(visitDate);
        outputView.printOrderMenuMessage(plan.getMenu());
        outputView.printBeforeDiscountMessage(plan.calcTotalPrice());
        outputView.printGiftMenuMessage(plan.getGifts());
        outputView.printDiscountContentMessage(plan.getDiscounts());
        outputView.printAllEventPriceMessage(plan.calcEventPrice());
        outputView.printAfterDiscountMessage(plan.calcFinalPrice());
        outputView.printEventBadgeMessage(plan.getBadge());
    }
}

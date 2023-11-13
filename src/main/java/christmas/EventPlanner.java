package christmas;

import christmas.models.Plan;
import christmas.models.RestaurantMenu;
import christmas.view.InputView;

import java.util.HashMap;

public class EventPlanner {

    private final InputView inputView = new InputView();
    private final EventPlanCalculator eventPlanCalculator = new EventPlanCalculator();

    public void start() {
        int visitDate = inputView.inputVisitDate();
        HashMap<RestaurantMenu, Integer> menu = inputView.inputMenu();

        Plan plan = eventPlanCalculator.calculate(menu, visitDate);


    }
}

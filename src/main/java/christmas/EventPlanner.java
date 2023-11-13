package christmas;

import christmas.models.RestaurantMenu;
import christmas.view.InputView;

import java.util.HashMap;

public class EventPlanner {

    private final InputView inputView = new InputView();

    public void start() {
        int visitDate = inputView.inputVisitDate();
        HashMap<RestaurantMenu, Integer> menu = inputView.inputMenu();


    }
}

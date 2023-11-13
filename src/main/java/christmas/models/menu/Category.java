package christmas.models.menu;

public enum Category {
    APPETIZER("애피타이저"),
    DESSERT("디저트"),
    DRINK("음료"),
    MAIN("메인");

    final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }
}

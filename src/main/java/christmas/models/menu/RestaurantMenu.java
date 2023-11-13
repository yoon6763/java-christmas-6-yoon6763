package christmas.models.menu;

import christmas.models.menu.Category;

public enum RestaurantMenu {
    /*
    <애피타이저>
    양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

    <메인>
    티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

    <디저트>
    초코케이크(15,000), 아이스크림(5,000)

    <음료>
    제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
     */

    // <애피타이저>
    MUSHROOM_SOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),

    // <메인>
    T_BONE_STEAK("티본스테이크", 55000, Category.MAIN),
    BBQ_RIB("바비큐립", 54000, Category.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN),

    // <디저트>
    CHOCOLATE_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),

    // <음료>
    ZERO_COLA("제로콜라", 3000, Category.DRINK),
    RED_WINE("레드와인", 60000, Category.DRINK),
    CHAMPAGNE("샴페인", 25000, Category.DRINK);


    final String menuTitle;
    final int price;
    final Category category;

    RestaurantMenu(String menuTitle, int price, Category category) {
        this.menuTitle = menuTitle;
        this.price = price;
        this.category = category;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}

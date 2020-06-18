package com.mycafe.utility;

public interface URLs {
    public static final String DEFAULT_URL = "/";

    public static final String HOME = "/home";
    public static final String CART = "/cart";
    public static final String PLACE_ORDER = "/placedOrder";
    public static final String LOGIN = "/login";
    public static final String KITCHEN = "/kitchen";
    public static final String WAITER = "/waiter";
    public static final String ADMIN = "/admin";

//    CRUD CONTROLLER URLS
    public static final String ADD_CATEGORY = "/addCategory";
    public static final String ADD_FOOD_BY_ID = "/foodAddCart/{id}";
    public static final String WAITER_TAKE_ORDER_BY_ID = "/waiter/{id}";
    public static final String DELETE_PLACED_ORDER_BY_ID = "/order.delete/{id}";
    public static final String FOOD_DELETE_BY_ID = "/food.delete/{id}";

//    VIEWS
    public static final String ADMIN_MENU = "/addFood_menu_view";
    public static final String CART_MENU = "/cart_menu_view";
    public static final String HOME_MENU = "/home_menu_view";
    public static final String LOGIN_MENU = "/login_menu_view";
    public static final String KITCHEN_MENU = "/kitchen_menu_view";
    public static final String WAITER_MENU = "/waiter_menu_view";
}

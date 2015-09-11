package restaurantorderingsystem;

import restaurantorderingsystem.menuitems.MenuItem;
import restaurantorderingsystem.menuitems.drink.Drink;
import restaurantorderingsystem.menuitems.drink.DrinkBuilder;
import restaurantorderingsystem.menuitems.lunch.cuisines.Lunch;

import java.util.Map;

public class RestaurantClient {

    Map<String, MenuItem> menuItemList;

    public RestaurantClient(Map<String, MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public MenuItem doOrderLunch(String order) {
        if (menuItemList.get(order) == null && menuItemList.get(order) instanceof Lunch) {
            throw new IllegalArgumentException ("No such lunch item: " + order);
        } else {
            return menuItemList.get(order);
        }
    }

    public MenuItem doOrderDrink(String order, Boolean withIce, Boolean withLemon){
        if (menuItemList.get(order) == null && menuItemList.get(order) instanceof Drink) {
            throw new IllegalArgumentException ("No such drink item: " + order);
        } else {
            Drink drink = (Drink) menuItemList.get(order);
            return new DrinkBuilder(drink).withIce(withIce).withLemon(withLemon).build();
        }

    }
}
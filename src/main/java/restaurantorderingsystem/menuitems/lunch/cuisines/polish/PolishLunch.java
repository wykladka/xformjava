package restaurantorderingsystem.menuitems.lunch.cuisines.polish;

import restaurantorderingsystem.menuitems.lunch.courses.Course;
import restaurantorderingsystem.menuitems.lunch.courses.Dessert;
import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;
import restaurantorderingsystem.menuitems.lunch.cuisines.Lunch;

import java.math.BigDecimal;

public class PolishLunch extends Lunch {

    public PolishLunch(String name, BigDecimal price) {
        super(name, price, new Course(CuisineType.POLISH), new Dessert(CuisineType.POLISH));
    }

}
package restaurantorderingsystem.menuitems.lunch.cuisines.italian;

import restaurantorderingsystem.menuitems.lunch.courses.Course;
import restaurantorderingsystem.menuitems.lunch.courses.Dessert;
import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;
import restaurantorderingsystem.menuitems.lunch.cuisines.Lunch;

import java.math.BigDecimal;

public class ItalianLunch extends Lunch {

    public ItalianLunch(String name, BigDecimal price) {
        super(name, price, new Course(CuisineType.ITALIAN), new Dessert(CuisineType.ITALIAN));
    }

}
package restaurantorderingsystem.menuitems.lunch.cuisines.mexican;

import restaurantorderingsystem.menuitems.lunch.courses.Course;
import restaurantorderingsystem.menuitems.lunch.courses.Dessert;
import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;
import restaurantorderingsystem.menuitems.lunch.cuisines.Lunch;

import java.math.BigDecimal;

public class MexicanLunch extends Lunch {

    public MexicanLunch(String name, BigDecimal price) {
        super(name, price, new Course(CuisineType.MEXICAN), new Dessert(CuisineType.MEXICAN));
    }

}
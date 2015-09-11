package restaurantorderingsystem.menuitems.lunch.cuisines;

import restaurantorderingsystem.menuitems.BaseMenuItem;
import restaurantorderingsystem.menuitems.lunch.courses.Course;
import restaurantorderingsystem.menuitems.lunch.courses.Dessert;

import java.math.BigDecimal;

public abstract class Lunch extends BaseMenuItem {

    private final Course course;
    private final Dessert dessert;

    public Lunch (String name, BigDecimal price, Course course, Dessert dessert){
        super(name, price);
        this.course = course;
        this.dessert = dessert;
    }

    public Course getCourse() {
        return course;
    }

    public Dessert getDessert() {
        return dessert;
    }
}
package restaurantorderingsystem.menuitems.lunch.courses;

import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;

public class Course {

    private CuisineType cousineType;

    public Course(CuisineType ct) {
        this.cousineType = ct;
    }

    public CuisineType getCousineType() {
        return cousineType;
    }
}
package restaurantorderingsystem.menuitems.lunch.courses;

import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;

public class  Dessert {
    private CuisineType cousineType;

    public Dessert(CuisineType ct) {
        this.cousineType = ct;
    }

    public CuisineType getCousineType() {
        return cousineType;
    }
}
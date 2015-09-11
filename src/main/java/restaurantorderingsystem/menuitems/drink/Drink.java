package restaurantorderingsystem.menuitems.drink;

import restaurantorderingsystem.menuitems.BaseMenuItem;

import java.math.BigDecimal;

public class Drink extends BaseMenuItem {

    Boolean hasIce;
    Boolean hasLemon;

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    public Boolean getHasIce() {
        return hasIce;
    }

    public void setHasIce(Boolean hasIce) {
        this.hasIce = hasIce;
    }

    public Boolean getHasLemon() {
        return hasLemon;
    }

    public void setHasLemon(Boolean hasLemon) {
        this.hasLemon = hasLemon;
    }
}
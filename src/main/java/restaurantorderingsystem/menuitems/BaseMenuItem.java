package restaurantorderingsystem.menuitems;

import java.math.BigDecimal;

public abstract class BaseMenuItem implements MenuItem {
    private String name;
    private BigDecimal price;

    public BaseMenuItem (String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

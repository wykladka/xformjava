package restaurantorderingsystem.menuitems.drink;

import java.math.BigDecimal;

public class DrinkBuilder {

    Drink drink;

    public DrinkBuilder (String name, BigDecimal price) {
        drink = new Drink(name, price);
    }

    public DrinkBuilder (Drink drink){
        this.drink = drink;
    }

    public DrinkBuilder withIce(Boolean withIce){
        drink.setHasIce(withIce);
        return this;
    }

    public DrinkBuilder withLemon(Boolean withLemon){
        drink.setHasLemon(withLemon);
        return this;
    }

    public Drink build(){
        if (drink.getHasLemon()== null) throw new IllegalStateException("Lemon field must be defined true or false");
        if (drink.getHasIce() == null) throw new IllegalStateException("Ice field must be defined true or false");
        return drink;
    }
}
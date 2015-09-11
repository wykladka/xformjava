package restaurantorderingsystem.ordertypes;

import org.junit.Before;
import org.junit.Test;
import restaurantorderingsystem.menuitems.drink.Drink;
import restaurantorderingsystem.menuitems.drink.DrinkBuilder;

import java.math.BigDecimal;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class DrinkBuilderTest {

    private Drink straight;
    private Drink withIceAndLemon;
    private Drink withIce;
    private Drink withLemon;

    public static final String dummyName = "Dummy name";
    public static final BigDecimal dummyPrice = new BigDecimal("100");

    @Before
    public void askBarmatenderForAllPossibleDrinkOrderCombinations() {
        straight = new DrinkBuilder(dummyName, dummyPrice)
                .withIce(false)
                .withLemon(false)
                .build();

        withIceAndLemon = new DrinkBuilder(dummyName, dummyPrice)
                .withIce(true)
                .withLemon(true)
                .build();

        withIce = new DrinkBuilder(dummyName, dummyPrice)
                .withIce(true)
                .withLemon(false)
                .build();

        withLemon = new DrinkBuilder(dummyName, dummyPrice)
                .withLemon(true)
                .withIce(false)
                .build();
    }

    @Test
    public void drinkHasOnlyLemon(){
        assertTrue(withLemon.getHasLemon());
        assertFalse(withLemon.getHasIce());
    }

    @Test
    public void drinkHasOnlyIce(){
        assertFalse(withIce.getHasLemon());
        assertTrue(withIce.getHasIce());
    }

    @Test
    public void drinkIsStraight(){
        assertFalse(straight.getHasLemon());
        assertFalse(straight.getHasIce());
    }

    @Test
    public void drinkHasIceAndLemon(){
        assertTrue(withIceAndLemon.getHasLemon());
        assertTrue(withIceAndLemon.getHasIce());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionForNoLemonFieldDefined(){
       Drink drink = new DrinkBuilder(straight).withIce(true).build();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionForNoIceFieldDefined() {
        Drink drink = new DrinkBuilder(straight).withLemon(true).build();
    }
}
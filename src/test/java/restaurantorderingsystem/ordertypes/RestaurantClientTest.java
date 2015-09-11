package restaurantorderingsystem.ordertypes;

import org.junit.Before;
import org.junit.Test;
import restaurantorderingsystem.RestaurantClient;
import restaurantorderingsystem.menuitems.MenuItem;
import restaurantorderingsystem.menuitems.drink.Drink;
import restaurantorderingsystem.menuitems.lunch.cuisines.CuisineType;
import restaurantorderingsystem.menuitems.lunch.cuisines.Lunch;
import restaurantorderingsystem.menuitems.lunch.cuisines.italian.ItalianLunch;
import restaurantorderingsystem.menuitems.lunch.cuisines.mexican.MexicanLunch;
import restaurantorderingsystem.menuitems.lunch.cuisines.polish.PolishLunch;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertTrue;

public class RestaurantClientTest {

    Map<String, MenuItem> menuItemList;

    private ItalianLunch lasagne;
    private MexicanLunch buritto;
    private PolishLunch pierogi;

    private Drink vodka;
    private Drink cocaCola;

    private RestaurantClient restaurantClient;

    private static final String DUMMY_MENU_ITEM_NAME = "Stek z kuraka";

    private static final BigDecimal ITALIAN_LUNCH_PRICE = new BigDecimal(50);
    private static final String ITALIAN_LUNCH_NAME = "Lasagne";

    private static final BigDecimal MEXICAN_LUNCH_PRICE = new BigDecimal(100);
    private static final String MEXICAN_LUNCH_NAME = "Buritto";

    private static final BigDecimal POLISH_LUNCH_PRICE = new BigDecimal(150);
    private static final String POLISH_LUNCH_NAME = "Pierogi";

    private static final BigDecimal VODKA_PRICE = new BigDecimal(400);
    private static final String VODKA_NAME = "Martini";

    private static final BigDecimal COCA_COLA_PRICE = new BigDecimal(200);
    private static final String COCA_COLA_NAME = "Light";

    MenuItem testItem = null;

    @Before
    public void prepareSampleMenu() {
        menuItemList = new HashMap<String, MenuItem>();
        prepareLunches();
        prepareDrinks();
        restaurantClient = new RestaurantClient(menuItemList);
    }

    public void prepareLunches() {
        prepareLasagne();
        prepareBuritto();
        preparePierogi();
    }

    private void prepareLasagne() {
        lasagne = new ItalianLunch(ITALIAN_LUNCH_NAME, ITALIAN_LUNCH_PRICE);
        addToItemList(lasagne);
    }

    private void prepareBuritto() {
        buritto = new MexicanLunch(MEXICAN_LUNCH_NAME, MEXICAN_LUNCH_PRICE);
        addToItemList(buritto);
    }

    private void preparePierogi() {
        pierogi = new PolishLunch(POLISH_LUNCH_NAME, POLISH_LUNCH_PRICE);
        addToItemList(pierogi);
    }

    public void prepareDrinks() {
        prepareStraightVodka();
        prepareCocaColaWithIceAndLemon();
    }

    private void prepareCocaColaWithIceAndLemon() {
        cocaCola = new Drink(COCA_COLA_NAME, COCA_COLA_PRICE);
        addToItemList(cocaCola);
    }

    private void prepareStraightVodka() {
        vodka = new Drink(VODKA_NAME, VODKA_PRICE);
        addToItemList(vodka);
    }

    private void addToItemList(MenuItem menuItem) {
        menuItemList.put(menuItem.getName(), menuItem);
    }

    @Test
    public void shouldReturnVodkaWithOnlyIce() {
        testItem = restaurantClient.doOrderDrink(VODKA_NAME, false, true);
        assertTrue(testItem instanceof Drink);
        assertTrue(VODKA_NAME.equals(testItem.getName()));
        assertTrue(VODKA_PRICE.equals(testItem.getPrice()));
        assertTrue(Boolean.TRUE.equals(((Drink) testItem).getHasIce()));
        assertTrue(Boolean.FALSE.equals(((Drink) testItem).getHasLemon()));
    }

    @Test
    public void shouldReturnCocaColaWithIceAndLemon() {
        testItem = restaurantClient.doOrderDrink(COCA_COLA_NAME, true, true);
        assertTrue(testItem instanceof Drink);
        assertTrue(COCA_COLA_NAME.equals(testItem.getName()));
        assertTrue(COCA_COLA_PRICE.equals(testItem.getPrice()));
        assertTrue(Boolean.TRUE.equals(((Drink) testItem).getHasIce()));
        assertTrue(Boolean.TRUE.equals(((Drink) testItem).getHasLemon()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void noSuchMenuLunchItemPositionTest() {
        restaurantClient.doOrderLunch(DUMMY_MENU_ITEM_NAME);
        restaurantClient.doOrderLunch(COCA_COLA_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noSuchMenuDrinkItemPositionTest() {
        restaurantClient.doOrderDrink(DUMMY_MENU_ITEM_NAME, true, true);
        restaurantClient.doOrderDrink(ITALIAN_LUNCH_NAME, true, true);
    }

    @Test
    public void shouldReturnItalianLunch() {
        testItem = restaurantClient.doOrderLunch(ITALIAN_LUNCH_NAME);
        assertTrue(testItem instanceof ItalianLunch);
        assertTrue(ITALIAN_LUNCH_NAME.equals(testItem.getName()));
        assertTrue(ITALIAN_LUNCH_PRICE.equals(testItem.getPrice()));
        assertTrue(CuisineType.ITALIAN.equals(((Lunch) testItem).getCourse().getCousineType()));
        assertTrue(CuisineType.ITALIAN.equals(((Lunch) testItem).getDessert().getCousineType()));
    }

    @Test
    public void shouldReturnMexicanLunch() {
        testItem = restaurantClient.doOrderLunch(MEXICAN_LUNCH_NAME);
        assertTrue(testItem instanceof MexicanLunch);
        assertTrue(MEXICAN_LUNCH_NAME.equals(testItem.getName()));
        assertTrue(MEXICAN_LUNCH_PRICE.equals(testItem.getPrice()));
        assertTrue(CuisineType.MEXICAN.equals(((Lunch) testItem).getCourse().getCousineType()));
        assertTrue(CuisineType.MEXICAN.equals(((Lunch) testItem).getDessert().getCousineType()));
    }

    @Test
    public void shouldReturnPolishLunch() {
        testItem = restaurantClient.doOrderLunch(POLISH_LUNCH_NAME);
        assertTrue(testItem instanceof PolishLunch);
        assertTrue(POLISH_LUNCH_NAME.equals(testItem.getName()));
        assertTrue(POLISH_LUNCH_PRICE.equals(testItem.getPrice()));
        assertTrue(CuisineType.POLISH.equals(((Lunch) testItem).getCourse().getCousineType()));
        assertTrue(CuisineType.POLISH.equals(((Lunch) testItem).getDessert().getCousineType()));
    }
}
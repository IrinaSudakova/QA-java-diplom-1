package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;

    private Bun bun;
    private List<Ingredient> ingredients;

    private Ingredient ingredient;

    @Before
    public void setUp() {
        bun = new Bun("Прекрасные булочки", 565.354f);
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.SAUCE, "вкусный ингридиент", 5.55f);
        ingredients = new ArrayList<>();
    }

    @After
    public void tearDown() {
        ingredients.clear();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(burger.bun.name, bun.getName());
        assertEquals(burger.bun.price, bun.getPrice(), 0.01);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 1);
        assertEquals(burger.ingredients.get(0), ingredient);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.size(), 1);
        assertEquals(burger.ingredients.get(0), ingredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.size(), 0);
    }

    @Test
    public void moveIngredient() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getReceipt() {
    }
}
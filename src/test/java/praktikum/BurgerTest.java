package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;
    private List<Ingredient> ingredients;

    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
        ingredients = mock(ArrayList.class);
    }

    @After
    public void tearDown() {
        ingredients.clear();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        // given
        addIngredient();
        // expected
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        // given
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertEquals(ingredient2, burger.ingredients.get(1));
        assertEquals(2, burger.ingredients.size());
        // expected
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void getPrice() {
        // given
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals(3, burger.ingredients.size());
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(200f);
        // expected
        assertEquals((burger.ingredients.size() * ingredient.getPrice() + 2 * bun.getPrice()), burger.getPrice(), 0.01);
    }

    @Test
    public void getReceipt() {
        // given
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.setBuns(bun);

        when(bun.getName()).thenReturn("Вкусная булка");
        when(ingredient1.getType()).thenReturn(SAUCE).toString().toLowerCase();
        when(ingredient2.getType()).thenReturn(SAUCE).toString().toLowerCase();
        when(ingredient3.getType()).thenReturn(FILLING).toString().toLowerCase();
        when(ingredient1.getName()).thenReturn("кетчуп");
        when(ingredient2.getName()).thenReturn("салат");
        when(ingredient3.getName()).thenReturn("котлета");
        when(burger.getPrice()).thenReturn(50.00f);
        // expected
        System.out.println(burger.getReceipt());
        assertEquals("(==== " + bun.getName() + " ====)\n" +
                "= " + ingredient1.getType().toString().toLowerCase() + " " + ingredient1.getName() + " =\n" +
                "= " + ingredient2.getType().toString().toLowerCase() + " " + ingredient2.getName() + " =\n" +
                "= " + ingredient3.getType().toString().toLowerCase() + " " + ingredient3.getName() + " =\n" +
                "(==== " + bun.getName() + " ====)\n" +
                "\nPrice: " + String.format("%f%n", burger.getPrice()), burger.getReceipt());
    }
}
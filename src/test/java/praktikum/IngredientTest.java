package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}:  type: {0}, name: {1}, price: {2}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "кетчуп", 10.23f},
                {SAUCE, "салат", Float.MAX_VALUE},
                {FILLING, "котлета", Float.MIN_VALUE},
                {null, null, 0}
        };
    }

    @Test
    public void getPrice() {
        assertPrice(createIngredient());
    }

    @Test
    public void getName() {
        assertName(createIngredient());
    }

    @Test
    public void getType() {
        assertType(createIngredient());
    }

    private Ingredient createIngredient() {
        return new Ingredient(type, name, price);
    }

    private void assertPrice(Ingredient ingredient) {
        assertEquals(price, ingredient.getPrice(), 0.01);
    }

    private void assertName(Ingredient ingredient) {
        assertEquals(name, ingredient.getName());
    }

    private void assertType(Ingredient ingredient) {
        assertEquals(type, ingredient.getType());
    }

}
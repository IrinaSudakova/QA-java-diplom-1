package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}:  name: {0}, price: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Самая вкусная булочка", 10.78f},
                {"С наибольшей ценой", Float.MAX_VALUE},
                {"С наименьшей ценой", Float.MIN_VALUE},
                {null, 0}
        };
    }

    @Test()
    public void testGetName() {
        assertName(createBun());
    }

    @Test
    public void getPrice() {
        assertPrice(createBun());
    }

    private Bun createBun() {
        return new Bun(name, price);
    }

    private void assertName(Bun bun) {
        Assert.assertEquals(name, bun.getName());
    }

    private void assertPrice(Bun bun) {
        Assert.assertEquals(price, bun.getPrice(), 0.01);
    }
}
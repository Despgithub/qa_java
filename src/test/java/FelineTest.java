import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class FelineTest {

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4}
        };
    }

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Test
    public void checkGetFamilyReturnFeline() {
        Feline feline = new Feline();
        Assert.assertEquals("Метод должен вернуть \"Кошачьи\" ", "Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatGetFoodCalledWithХищник() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void checkKittens() {
        Feline feline = new Feline();
        Assert.assertEquals("getKittens() должен вернуть 1", 1, feline.getKittens());
    }

    @Test
    public void checkKittensWithTestData() {
        Feline feline = new Feline();
        Assert.assertEquals("getKittens() должен вернуть kittensCount", expectedKittensCount, feline.getKittens(kittensCount));
    }
}
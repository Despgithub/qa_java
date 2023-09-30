import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test()
    public void checkConstructorShowException() {
        Exception actualExeption = assertThrows(Exception.class, () ->
                new Lion("Самей", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", actualExeption.getMessage());
    }

    @Test
    public void checkGetKittenMethodCalled() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void checkHaveManeReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("", lion.doesHaveMane());
    }

    @Test
    public void checkHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse("", lion.doesHaveMane());
    }

    @Test
    public void checkFelineGetFoodCalledWithPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
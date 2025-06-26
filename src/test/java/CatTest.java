import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatTest {
    private Feline feline; // Объявляем переменную для класса Feline
    private Cat cat; // Объявляем переменную для класса Cat

    @Before
    public void setUp() {
        // Создаем мок объект для класса Feline
        feline = Mockito.mock(Feline.class);
        // Инициализируем объект Cat, передавая ему мок объект Feline
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        // Проверяем что метод getSound() возвращает правильный звук для кошки
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        assertEquals(expected, cat.getFood());
    }
}


import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        // Создали мок объект Feline
        feline = Mockito.mock(Feline.class);
        // Создали экземпляра Lion с мок объектом Feline
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        // Проверка что у самца есть грива
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        // Мок объекта: когда вызывается метод getKittens(), возвращать 2
        Mockito.when(feline.getKittens()).thenReturn(2);

        // Проверяем что метод getKittens() класса Lion возвращает 2
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Feline feline = new Feline();
        // Проверяем, что при передаче некорректного значения пола будет выброшено исключение
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        // Проверяем, что сообщение исключения соответствует ожидаемому
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}


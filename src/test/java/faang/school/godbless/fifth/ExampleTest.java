package faang.school.godbless.fifth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {
//1. Arrange — подготовка данных и настройка тестируемого объекта;
//2. Act — выполнение действия или вызов метода, который тестируется;
//3. Assert — проверка результата теста и утверждения, что они соответствуют ожидаемому поведению.
    @Test
    public void shouldRevertArrayWithOddSize() {
        int[] testArray1 = new int[] {1, 2, 3};
        int[] testArray2 = new int[] {500, 5, 2, 1, 47};

        int[] result1 = Example.reverse(testArray1);
        int[] expected1 = new int[] {3, 2, 1};
        int[] result2 = Example.reverse(testArray2);
        int[] expected2 = new int[] {47, 1, 2, 5, 500};

        assertArrayEquals(expected1, result1);
        assertArrayEquals(expected2, result2);
    }
}
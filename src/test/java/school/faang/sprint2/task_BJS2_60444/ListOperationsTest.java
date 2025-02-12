package school.faang.sprint2.task_BJS2_60444;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {
    private List<String> strings;
    private List<Integer> integers;
    private final char startChar = 'a';

    @BeforeEach
    public void setUp() {
        strings = new ArrayList<>(List.of("apple", "banana", "cherry", "date"));
        integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("Получение суммы четных чисел в массиве")
    public void sumOfEvenNumbers_rightParam() {
        integers.add(null);
        long sumOfEvenNumbers = 12;
        assertEquals(sumOfEvenNumbers, ListOperations.sumOfEvenNumbers(integers));
    }

    @Test
    @DisplayName("Ошибка получение суммы четных чисел в null массиве")
    public void sumOfEvenNumbers_nullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.sumOfEvenNumbers(null));
    }

    @Test
    @DisplayName("Ошибка получение суммы четных чисел в пустом массиве")
    public void sumOfEvenNumbers_emptyArray() {
        integers.clear();
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.sumOfEvenNumbers(integers));
    }

    @Test
    @DisplayName("Ошибка получение суммы четных чисел в массиве только с null")
    public void sumOfEvenNumbers_OnlyNullIntoArray() {
        integers.clear();
        integers.add(null);

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.sumOfEvenNumbers(integers));
    }

    @Test
    @DisplayName("Получение наибольшего числа в массиве")
    public void findMax_rightParam() {
        int maxNumber = 6;
        assertEquals(maxNumber, ListOperations.findMax(integers));
    }

    @Test
    @DisplayName("Получение среднеарифметического числа в массиве")
    public void findAverage_rightParam() {
        double averageNumbers = 3.5D;
        assertEquals(averageNumbers, ListOperations.findAverage(integers));
    }

    @Test
    @DisplayName("Получение массива строк которые начинаются с определенного символа")
    public void countStringsStartingWith_rightParam() {
        integers.add(null);
        long countStrings = 1;
        assertEquals(countStrings, ListOperations.countStringsStartingWith(strings, startChar));
    }


    @Test
    @DisplayName("Ошибка получения массива если массив null")
    public void countStringsStartingWith_nullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.countStringsStartingWith(null, startChar));
    }

    @Test
    @DisplayName("Ошибка получения массива если массив пустой")
    public void countStringsStartingWith_emptyArray() {
        strings.clear();
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.countStringsStartingWith(strings, startChar));
    }

    @Test
    @DisplayName("Ошибка получения массива если массив содержит только null")
    public void countStringsStartingWith_OnlyNullIntoArray() {
        strings.clear();
        strings.add(null);

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.countStringsStartingWith(strings, startChar));
    }

    @Test
    @DisplayName("Получение массива строк содержащих подстроку")
    public void filterStringsContainingSubstring_rightParam() {
        List<String> stringsWithSubString = List.of("banana");
        String subString = "an";
        assertEquals(stringsWithSubString, ListOperations.filterStringsContainingSubstring(strings, subString));
    }

    @Test
    @DisplayName("Ошибка получения массива при null подстроке ")
    public void filterStringsContainingSubstring_nullSubString() {
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterStringsContainingSubstring(strings, null));
    }

    @Test
    @DisplayName("Ошибка получения массива при пустой подстроке ")
    public void filterStringsContainingSubstring_blankSubString() {
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterStringsContainingSubstring(strings, " "));
    }

    @Test
    @DisplayName("Сортировка массива строк по их длине")
    public void sortByLength_blankSubString() {
        List<String> sortedByLength = List.of("date", "apple", "banana", "cherry");
        assertEquals(sortedByLength, ListOperations.sortByLength(strings));
    }

    @Test
    @DisplayName("Проверка массива на четность элементов")
    public void allMatchCondition_isEven() {
        assertFalse(ListOperations.allMatchCondition(integers, n -> n % 2 == 0));
    }

    @Test
    @DisplayName("Ошибка проверки массива при null условии")
    public void allMatchCondition_nullCondition() {
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.allMatchCondition(integers, null));
    }

    @Test
    @DisplayName("Получение минимального числа после стартового")
    public void findMinGreaterThan_rightParam() {
        int minAfterStart = 5;
        int startInt = 4;
        assertEquals(minAfterStart, ListOperations.findMinGreaterThan(integers, startInt));
    }

    @Test
    @DisplayName("Получение массива длин строк")
    public void convertToLengths_rightParam() {
        List<Integer> lengthStrings = List.of(5, 6, 6, 4);
        assertEquals(lengthStrings, ListOperations.convertToLengths(strings));
    }
}















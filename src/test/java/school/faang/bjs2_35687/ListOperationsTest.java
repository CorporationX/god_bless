package school.faang.bjs2_35687;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    @Test
    void sumEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int correctResult = 12;
        int result = ListOperations.sumEvenNumbers(numbers);
        assertEquals(correctResult, result);
    }

    @Test
    void findMaxElement() {
        List<Integer> numbers = Arrays.asList(3, 7, 1, 9, 2);
        int correctResult = 9;
        int result = ListOperations.findMaxElement(numbers);
        assertEquals(correctResult, result);

        List<Integer> emptyListTest = new ArrayList<>();
        NoSuchElementException exceptionEmptyList = assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMaxElement(emptyListTest));
        String correctErrMessage = "list is empty";
        assertEquals(correctErrMessage, exceptionEmptyList.getMessage());
    }

    @Test
    void findAverageOfNumbers() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        double correctResult = 5.0;
        double result = ListOperations.findAverageOfNumbers(numbers);
        assertEquals(correctResult, result);

        List<Integer> emptyListTest = new ArrayList<>();
        NoSuchElementException exceptionEmptyList = assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMaxElement(emptyListTest));
        String correctErrMessage = "list is empty";
        assertEquals(correctErrMessage, exceptionEmptyList.getMessage());
    }

    @Test
    void countStringsStartingWith() {
        List<String> strings = Arrays.asList("apple", "apricot", "banana", "avocado", "berry");
        char startChar = 'a';
        int correctResult = 3;
        int result = ListOperations.countStringsStartingWith(strings, startChar);
        assertEquals(correctResult, result);
    }

    @Test
    void filterStringsContaining() {
        List<String> strings = Arrays.asList("hello", "world", "hell", "help", "hero");
        String substring = "he";
        List<String> correctResult = Arrays.asList("hello", "hell", "help", "hero");
        List<String> result = ListOperations.filterStringsContaining(strings, substring);
        assertEquals(correctResult, result);

    }

    @Test
    void sortStringsByLength() {
        List<String> strings = Arrays.asList("elephant", "cat", "hippopotamus", "dog");
        List<String> correctResult = Arrays.asList("cat", "dog", "elephant", "hippopotamus");
        List<String> result = ListOperations.sortStringsByLength(strings);
        assertEquals(correctResult, result);
    }

    @Test
    void allMatchCondition() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Predicate<Integer> condition = num -> num % 10 == 0;
        boolean correctResult = true;
        boolean result = ListOperations.allMatchCondition(numbers, condition);
        assertEquals(correctResult, result);
    }

    @Test
    void findMinGreaterThan() {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        int threshold = 6;
        int correctResult = 7;
        int result = ListOperations.findMinGreaterThan(numbers, threshold);
        assertEquals(correctResult, result);

        List<Integer> emptyListTest = new ArrayList<>();
        NoSuchElementException exceptionEmptyList = assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMaxElement(emptyListTest));
        String correctErrMessage = "list is empty";
        assertEquals(correctErrMessage, exceptionEmptyList.getMessage());
    }

    @Test
    void mapStringsToLengths() {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi");
        List<Integer> correctResult = Arrays.asList(5, 6, 4);
        List<Integer> result = ListOperations.mapStringsToLengths(strings);
        assertEquals(correctResult, result);
    }
}
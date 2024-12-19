package school.faang.bjs247191;

import java.util.Arrays;
import java.util.List;

import static school.faang.bjs247191.StreamApi1.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        sumEvenNumbers(numbers);
        maxListElement(numbers);
        averageListElement(numbers);
        countStringCountWith(strings, 'a');
        filterStringsContainingSubstring(strings, "apple");
        sortList(strings);
        isSatisfyCertainConditions(numbers, num -> num > 0);
        findMinGreaterThan(numbers, 3);
        lenghtEachStrings(strings);
    }
}

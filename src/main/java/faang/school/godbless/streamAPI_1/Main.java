package faang.school.godbless.streamAPI_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");

        System.out.println(Math.sumOfEvenNumbers(nums));
        System.out.println(Math.maxInEventNumbers(nums));
        System.out.println(Math.average(nums));
        System.out.println(Math.countStringsStartingWith(strings, 'b'));
        System.out.println(Math.filterStringsContainingSubstring(strings));
        System.out.println(Math.sortStringsByLength(strings));
        System.out.println(Math.allElementsSatisfyCondition(nums, x -> x < 20));
        System.out.println(Math.minElement(nums, 5));
        System.out.println(Math.lengthsStrings(strings));
    }
}

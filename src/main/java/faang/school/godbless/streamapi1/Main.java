package faang.school.godbless.streamapi1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,4,3,2));
        List<String> stringList = new ArrayList<>(Arrays.asList("abab", "bb", "cb", "avavab"));

        System.out.println(MathMethods.sumOfEvenNumbers(nums));

        System.out.println(MathMethods.maxElement(nums));

        System.out.println(MathMethods.mean(nums));

        System.out.println(MathMethods.numberOfStrings(stringList, 'd'));

        System.out.println(MathMethods.filterBySubstring(stringList, "cc"));

        System.out.println(MathMethods.sortByLength(stringList));

        System.out.println(MathMethods.allElementsMatchCondition(stringList, 'b'));

        try {
            System.out.println(MathMethods.findMinGreaterThan(nums, 3));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(MathMethods.listToLength(stringList));
    }
}

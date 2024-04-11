package faang.school.godbless.streamAPI.streamAPI1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, -8, 9, 10);
        var strings = List.of("Somebody", "once", "told", "me", "the", "world", "is", "gonna", "roll", "me");

        System.out.println(nums);
        System.out.println(strings);
        System.out.println();

        System.out.println("The sum of even numbers: " + SwissKnife.getEvenNumsSum(nums));

        System.out.println("The max of numbers: " + SwissKnife.getMax(nums).orElse(0));

        System.out.println("The mean of numbers: " + SwissKnife.getMeanNum(nums));

        System.out.println("The number of strings beginning with symbol 't': " + SwissKnife.getStringsNumBeginWith(strings, 't'));

        System.out.println("The list of strings containing \"ol\":");
        System.out.println(SwissKnife.filterStringsByContainingSubstring(strings, "ol"));

        System.out.println("Strings sorted by length:");
        System.out.println(SwissKnife.sortByLength(strings));

        System.out.println("Does all nums are greater than zero: " + SwissKnife.satisfiesCondition(nums, num -> num > 0));

        System.out.println("The min number bigger than 5: " + SwissKnife.getMinBiggerThan(nums, 5).orElse(0));

        System.out.println("Lengths of strings: ");
        System.out.println(SwissKnife.stringsToLengths(strings));
    }
}

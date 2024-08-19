package faang.school.godbless.BJS2_23140;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
        List<String> strings = new ArrayList<>(List.of("aa", "abaa", "cba"));

        System.out.println(Streams.sumEvenNumbers(nums));
        System.out.println(Streams.max(nums));
        System.out.println(Streams.average(nums));
        System.out.println(Streams.findNumberStartingWithCertainCharacter(strings, 'a'));
        System.out.println(Streams.filterBySubstring(strings, "aa"));
        Streams.sortByLengthString(strings);
        System.out.println(strings);
        System.out.println(Streams.isAllMatches(strings, (string -> string.contains("a"))));
        System.out.println(Streams.findMinNumberThanTarget(nums, 5));
        System.out.println(Streams.stringsToLengthStrings(strings));
    }
}

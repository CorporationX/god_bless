package faang.school.godbless.BJS2_23087;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 7, 8, 3);
        System.out.println("Sum of even numbers: " + StreamProcessor.sumEvenNumbers(nums));

        Optional<Integer> maxNumber = StreamProcessor.findMaxNumber(nums);
        maxNumber.ifPresent(number -> System.out.println("Max of numbers: " + number));

        OptionalDouble avgOfNumbers = StreamProcessor.findAvgOfNumbers(nums);
        avgOfNumbers.ifPresent(avg -> System.out.println("Average of numbers: " + avg));

        List<String> strings = List.of("apple", "banana", "apricot", "avocado", "berry");
        char prefix = 'a';
        long count = StreamProcessor.countStringsStartingWith(prefix, strings);
        System.out.println("Number of lines starting with " + prefix + ": " + count);

        String substring = "ap";
        Optional<List<String>> stringsBySubstring = StreamProcessor.filterStringsBySubstring(substring, strings);
        System.out.println("Filtered strings by substring '" + substring + "':");
        stringsBySubstring.ifPresent(substringStrings -> substringStrings.forEach(System.out::println));

        System.out.println("Sorted list by string's length:");
        StreamProcessor.sortStringsByLength(strings).forEach(System.out::println);

        System.out.println("If all strings in list have length more than 4:");
        System.out.println(StreamProcessor.allMatch(strings, string -> string.length() > 4));

        System.out.println("All elements from list more than 6:");
        StreamProcessor.findMinNumberThan(6, nums).ifPresent(System.out::println);

        System.out.println("Converting list of string to list of strings length:");
        StreamProcessor.mapToStringsLength(strings).forEach(System.out::println);
    }
}

package faang.school.godbless.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class Example {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 9, 2, 8);
        List<String> strings = Arrays.asList("Hogwarts", "Lamborgini", "Throne", "Batmen", "Superman");

        int sum = StreamApi.add(numbers);
        System.out.println(sum);

        try {
            int max = StreamApi.findMax(numbers);
            System.out.println("Max: " + max);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


        double average = StreamApi.findAverage(numbers);
        System.out.println("Average: " + average);

        long count = StreamApi.countStringStartWith(strings, 'B');
        System.out.println("Count: " + count);

        List<String> filteredStrings = StreamApi.filterStringContainsSubstring(strings, "an");
        System.out.println("FilteredStrings: " + filteredStrings);

        List<String> sortedStrings = StreamApi.filterStringByLength(strings);
        System.out.println("SortedStrings: " + sortedStrings);

        Predicate<String> predicate = s -> s.length() > 5;
        boolean anyMatch = StreamApi.anyMatchTest(strings, predicate);
        System.out.println("AnyMatch: " + anyMatch);

        Optional<Integer> smallestGreaterThan = StreamApi.findSmallestGreaterThan(numbers, 3);
        smallestGreaterThan.ifPresentOrElse(
                value -> System.out.println("Smallest number greater than 3" + value),
                () -> System.out.println("Smallest number greater than 3")
        );

        List<Integer> lengths = StreamApi.convertToLength(strings);
        System.out.println("Lengths: " + lengths);
    }
}

package school.faang.task221.service;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamService.countEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        System.out.println(StreamService.maxNumber(List.of(12, 25)));
        System.out.println(StreamService.avg(List.of(25, 50, 75)));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(StreamService.countStringWithSimilarStart(strings, "a"));

        StreamService.getStringWithSimilarStart(strings, "ba").forEach(System.out::println);
        StreamService.sortByStringLeanth(strings).forEach(System.out::println);
        StreamService.getListOfStringsSize(strings).forEach(System.out::println);

        System.out.println(StreamService.checkPredicateForList(List.of(2, 2, 2, 2, 2, 2), p -> p % 2 == 0));
        System.out.println(StreamService.findSmallestNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 7));
    }
}

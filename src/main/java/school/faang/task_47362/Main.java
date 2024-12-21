package school.faang.task_47362;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Pairs with sum 7: " + Utils.findPairs(numbers, 7));

        Map<String, String> countries = Map.of(
                "USA", "Washington",
                "Canada", "Ottawa",
                "India", "New Delhi"
        );
        System.out.println("Sorted capitals: " + Utils.getSortedCapitals(countries));

        List<String> strings = List.of("apple", "banana", "apricot", "avocado");
        System.out.println("Filtered and sorted strings: " + Utils.filterAndSort(strings, 'a'));

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println("Binary representation: " + Utils.convertToBinary(nums));

        List<String> stringList = List.of("apple", "banana", "carrot", "applause", "ball");
        System.out.println("Filtered and sorted by length: " + Utils.filterAndSortByLength(stringList, "abc"));
    }
}
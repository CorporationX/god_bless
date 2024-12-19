package school.faang.task_47362;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Pairs with sum 7: " + Utils.findPairs(numbers, 7));

        Map<String, String> countries = Map.of(
                "USA", "Washington",
                "Canada", "Ottawa",
                "India", "New Delhi"
        );
        System.out.println("Sorted capitals: " + Utils.getSortedCapitals(countries));

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "avocado");
        System.out.println("Filtered and sorted strings: " + Utils.filterAndSort(strings, 'a'));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Binary representation: " + utils.convertToBinary(nums));

        List<String> stringList = Arrays.asList("apple", "banana", "carrot", "applause", "ball");
        System.out.println("Filtered and sorted by length: " + utils.filterAndSortByLength(stringList, "abc"));
    }
}

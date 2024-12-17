package school.faang.sprint_2.task_47298;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, String>
            countries = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> listOfStrings =
            Arrays.asList("apple", "Banana", "cherry", "date", "fig", "grape");

        ListOperations.findPairs(numbers, 7).forEach(System.out::println);
        ListOperations.getCountry(countries).forEach(System.out::println);
        ListOperations.filterAndSort(strings, 'a').forEach(System.out::println);
        ListOperations.convertToBinary(numbers).forEach(System.out::println);
        ListOperations.filterAndSortByLength(listOfStrings, "abcdefghijklmnopqrstuvwxyz")
            .forEach(System.out::println);
    }
}

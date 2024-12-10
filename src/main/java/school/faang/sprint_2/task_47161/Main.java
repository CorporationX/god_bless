package school.faang.sprint_2.task_47161;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countriesCity = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        List<String> anotherStrings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(ListOperations.findPairOfNumbers(numbers, 7));
        System.out.println(ListOperations.sortCapitals(countriesCity));
        System.out.println(ListOperations.filterAndSortStrings(strings, 'a'));
        System.out.println(ListOperations.convertToBinary(numbers));
        System.out.println(ListOperations.filterAndSortByLength(anotherStrings, alphabet));
    }




}

package school.faang.sprint_2.task_47399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 34, 12, 22, 2, 1, 6);
        System.out.println(Filters.uniquePairsOfNumbers(numbers, 7));

        Map<String, String> countryAndCapital = new HashMap<>();
        countryAndCapital.put("Russia", "Moscow");
        countryAndCapital.put("USA", "Washington");
        countryAndCapital.put("Germany", "Berlin");
        System.out.println(Filters.countryAndCapital(countryAndCapital));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "strawberry", "blueberry");
        System.out.println(Filters.sortingStrings(strings, 'b'));

        System.out.println(Filters.binaryFormat(numbers));

        String abc = "abcdefghijklmnopqrstuvwx";
        System.out.println(Filters.sortAlphabetically(strings, abc));
    }
}
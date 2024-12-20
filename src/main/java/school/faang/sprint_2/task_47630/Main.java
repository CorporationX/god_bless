package school.faang.sprint_2.task_47630;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<int[]> pairs = Operation.findPairs(numbers, target);
        System.out.println("Уникальные пары чисел:");
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        Map<String, String> countryCapitalMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> capitals = Operation.sortCapitals(countryCapitalMap);
        System.out.println("Столицы, отсортированные по странам:");
        System.out.println(capitals);

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        List<String> filteredSortedStrings = Operation.filterAndSortStrings(strings, startChar);
        System.out.println("Строки, начинающиеся с 'a' и отсортированные по длине:");
        System.out.println(filteredSortedStrings);

        List<Integer> numbersToConvert = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = Operation.convertToBinary(numbersToConvert);
        System.out.println("Числа в двоичном формате:");
        System.out.println(binaryStrings);

        List<String> stringsForAlphabet = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredAlphabetStrings = Operation.filterByAlphabetAndSort(stringsForAlphabet, alphabet);
        System.out.println("Строки, содержащие только буквы алфавита, отсортированные по длине:");
        System.out.println(filteredAlphabetStrings);
    }
}
package streamApiTwo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, String> countryAndCapital = new HashMap<>() {{
            put("Russia", "Moscow");
            put("USA", "Washington");
            put("Germany", "Berlin");
        }};
        List<String> fruit = List.of("apple", "banana", "avocado", "apricot");
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        Main main = new Main();
        main.uniquePairsOfNumbers(numbers, 13);
        main.capitalsOfSortedCountry(countryAndCapital);
        main.filterAndSortStrings(fruit, 'a');
        main.sortByAlphabetAndLength(strings);
        main.convertNumbersToBinary(numbers);
    }

    public void uniquePairsOfNumbers(List<Integer> numbers, int targetNumber) {
        Set<Integer> checkNums = new HashSet<>();
        System.out.println(
                numbers.stream()
                        .peek(checkNums::add)
                        .filter(n -> checkNums.contains(targetNumber - n))
                        .map(n -> "(%d, %d)".formatted(n, targetNumber - n))
                        .toList()
        );
    }

    public void capitalsOfSortedCountry(Map<String, String> countries) {
        System.out.println(
                countries.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .toList()
        );
    }

    public void filterAndSortStrings(List<String> strings, char character) {
        System.out.println(
                strings.stream()
                        .filter(str -> str.charAt(0) == character)
                        .sorted(Comparator.comparing(String::length))
                        .toList()
        );
    }

    public void sortByAlphabetAndLength(List<String> strings) {
        System.out.println(
                strings.stream()
                        .sorted(Comparator.naturalOrder())
                        .sorted(Comparator.comparing(String::length))
                        .toList()
        );
    }

    public void convertNumbersToBinary(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                        .map(Integer::toBinaryString)
                        .toList()
        );
    }
}

package school.faang.task_47069;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 5, 7, 2, 3, 4, 6, 1, 4, 2));
        Map<String, String> countries = new HashMap<>(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        ));
        List<String> fruits = new ArrayList<>(List.of("apple", "banana", "cherry", "date", "fig", "grape"));
        System.out.println(uniqueCouple(numbers, 7));
        System.out.println(sortByAlphabetReturnCapital(countries));
        System.out.println(filterAndLength(fruits, "a"));
        System.out.println(numbersToBinary(numbers));
        System.out.println(alphabetAndLength(fruits, ALPHABET));
    }

    public static Set<List<Integer>> uniqueCouple(List<Integer> numbers, int aim) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numbers.stream()
                .filter(n -> numberSet.contains(aim - n))
                .map(n -> Arrays.asList(n, aim - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortByAlphabetReturnCapital(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndLength(List<String> fruits, String character) {
        return fruits.stream()
                .filter(fruit -> fruit.startsWith(character))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> numbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> alphabetAndLength(List<String> fruits, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return fruits.stream()
                .filter((fruit) -> fruit.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

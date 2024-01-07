package faang.school.godbless;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Application {


    public static void main(String... args) {

        System.out.println(Application.uniqueidPairs());
        System.out.println(Application.sortingCountries());
        System.out.println(Application.sortingString());
        System.out.println(Application.searchingFriends());
        System.out.println(Employee.averageSalary());
        System.out.println(Application.filteringStrings());
        System.out.println(Application.numbersToBinaryStrings());
        System.out.println(Application.findPalindromes());
    }

    public static List<List<Integer>> uniqueidPairs() {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        List<List<Integer>> pairs = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == targetSum && numbers.indexOf(j) > numbers.indexOf(i))
                        .map(j -> Arrays.asList(i, j)))
                .distinct()
                .toList();
        return pairs;
    }

    public static List<String> sortingCountries() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington D.C.");
        countries.put("China", "Beijing");
        countries.put("Japan", "Tokyo");
        countries.put("France", "Paris");
        countries.put("Germany", "Berlin");
        countries.put("United Kingdom", "London");
        countries.put("Italy", "Rome");
        countries.put("India", "New Delhi");
        countries.put("Brazil", "Brasília");

        List<String> capitalCity = countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return capitalCity;
    }
    public static List<String> sortingString(){
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape",
                "blueberry", "blackberry");
        char ch = 'b';
        List<String> sortString = strings.stream()
                .filter(s -> s.toLowerCase().startsWith(String.valueOf(ch).toLowerCase()))
                .sorted(Comparator.comparing(String::length))
                .toList();
        return sortString;
    }
    public static List<List<String>> searchingFriends(){
        Map<String, List<String>> friends = new HashMap<>();
        {
            friends.put("Alice", Arrays.asList("Bob", "Charlie", "David"));
            friends.put("Bob", Arrays.asList("Alice", "Eve"));
            friends.put("Charlie", Arrays.asList("Alice", "David"));
            friends.put("David", Arrays.asList("Alice", "Charlie"));
            friends.put("Eve", Arrays.asList("Bob", "Trump"));
        }
        return friends.entrySet().stream()
                .flatMap(entry1 -> friends.entrySet().stream()
                                .filter(entry2 -> !entry1.getKey().equals(entry2.getKey()))
                                .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                                .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                                .map(entry2 -> {
                                    List<String> pair = new ArrayList<>(List.of(entry1.getKey(), entry2.getKey()));
                                    pair.sort(Comparator.naturalOrder()); // Сортировка имен в паре
                                    return pair;
                                })
                )
                .distinct()
                .toList();
    }
    public static List<String> filteringStrings(){
        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat");

        List<String> filterStrings = strings.stream()
                .filter(s -> s.matches("[a-z]+"))
                .sorted(Comparator.comparing(String::length))
                .toList();
        return filterStrings;
    }
    public static List<String> numbersToBinaryStrings() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }
    public static List<Integer> findPalindromes() {
        return IntStream.iterate(100, n -> n + 1).limit(100)
                .filter(number -> {
                    int reversed = 0;
                    int original = number;
                    while (number > 0) {
                        reversed = reversed * 10 + number % 10;
                        number /= 10;
                    }
                    return original == reversed;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}

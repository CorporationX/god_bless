package school.faang.task_47312;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(findPair(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)), 7));

        Map<String, String> capitalsAndCountries = new HashMap<>();
        capitalsAndCountries.put("Russia", "Moscow");
        capitalsAndCountries.put("USA", "Washington");
        capitalsAndCountries.put("Germany", "Berlin");
        System.out.println(sortingCapitals(capitalsAndCountries));

        System.out.println(sortingList(new ArrayList<>(List.of("banana", "avocado",
                "apricot", "apple")), 'a'));

        System.out.println(convertToBinary(new ArrayList<>(List.of(1, 2, 3, 4))));

        System.out.println(stringFiltering(new ArrayList<>(List.of("apple", "banana",
                "cherry", "date", "fig", "grape"))));
    }

    public static Set<List<Integer>> findPair(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairNumbers;
        Set<Integer> number = new HashSet<>(numbers);

        pairNumbers = numbers.stream()
                .filter(num -> number.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairNumbers;
    }

    public static List<String> sortingCapitals(Map<String, String> capitalsAndCountries) {
        List<String> sortedCapitals;

        sortedCapitals = capitalsAndCountries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
        return sortedCapitals;
    }

    public static List<String> sortingList(List<String> list, char symbol) {
        List<String> sortedList;

        sortedList = list.stream()
                .filter(string -> string.indexOf(symbol) == 0)
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        return sortedList;
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        List<String> binaryNumbers;

        binaryNumbers = numbers.stream()
                .map(Integer::toBinaryString)
                .toList();

        return binaryNumbers;
    }

    public static List<String> stringFiltering(List<String> strings) {
        String alf = "abcdefghijklmnopqrstuvwxyz";
        String regex = "[" + alf + "]+";

        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}

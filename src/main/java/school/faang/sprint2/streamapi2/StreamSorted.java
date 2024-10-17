package school.faang.sprint2.streamapi2;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSorted {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 8;
        Set<List<Integer>> pairs = findPairs(numbers, targetSum);
        System.out.println(pairs);

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        List<String> capitals = getSortedCapital(countries);
        System.out.println(capitals.toString());

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char chars = 97;
        Set<List<String>> asd = Collections.singleton(filterAndSort(strings, chars));
        System.out.println(asd);

        List<Integer> input = List.of(1, 5, 6, 99, 34, 6654);
        List<String> output = binary(input);
        System.out.println(output);
        List<Integer> input1 = List.of(0101, 10, 6, 99, 1100, 6654);
        List<String> output1 = octal(input1);
        System.out.println(output1);

        List<String> dictionary = Arrays.asList("apple", "banana", "adf", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> fileAndSort = filterAndSortStrings(dictionary, alphabet);
        System.out.println(fileAndSort);
    }

    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        return pairs;
    }

    public static List<String> getSortedCapital(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

    }

    public static List<String> filterAndSort(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> binary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> octal(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toOctalString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, String alphabets) {
        String regex = "[" + alphabets + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

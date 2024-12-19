package school.faang.spring2.task_47435;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(findPairs(List.of(1, 2, 3, 4, 5, 6), 7));
        Map<String, String> map = new HashMap<>();
        map.put("Russia", "Moscow");
        map.put("USA", "Washington");
        map.put("Germany", "Berlin");
        System.out.println(getSortedCapitals(map));
        System.out.println(startWithByCharAndSort(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        List<String> input = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> result = filterAndSortByLength(input, alphabet);

        System.out.println(result);

    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = String.format("[%s]+", alphabet);
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public List<String> convertToBinary(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> startWithByCharAndSort(List<String> list, char c) {
        return list.stream().filter(e -> e.charAt(0) == c)
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(Math.min(num, sum - num), Math.max(num, sum - num)))
                .collect(Collectors.toSet());
    }
}

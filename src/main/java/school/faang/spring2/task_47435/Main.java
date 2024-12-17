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
        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabetSet.contains((char) ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
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
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        return numbers.stream()
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }
}

package school.faang.task_47040;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    public static Set<List<Integer>> getUniquePairs(List<Integer> numbers, int target) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(target - num) && num != target - num)
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countriesWithCapitals) {
        return countriesWithCapitals.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortingStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("a"))
                .sorted((Comparator.comparing(String::length)))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> isExistAlphabet(s, alphabet))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static boolean isExistAlphabet(String input, String alphabet) {
        return input.chars().mapToObj(c -> String.valueOf((char) c)).allMatch(alphabet::contains);
    }
}

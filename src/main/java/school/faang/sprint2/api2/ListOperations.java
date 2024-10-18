package school.faang.sprint2.api2;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> uniquePair(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(a -> numbers.contains(num - a) && a <= numbers.size()/2)
                .map(a -> Arrays.asList(a, num -a))
                .collect(Collectors.toSet());
    }

    public static List<String> capitalsSortedByCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> sortedStrings(List<String> strings, char symbol) {
        return strings.stream()
                .filter(word -> word.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> numToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> alphabetStrings(List<String> strings2, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings2.stream().filter(word -> word.matches(regex))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}

package school.faang.streamexercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitalsByCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .filter(entry -> entry.getKey() != null && entry.getValue() != null)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> stringList, char firstLetter) {
        return stringList.stream()
                .filter(s -> s != null && s.startsWith(String.valueOf(firstLetter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryStrings(Set<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> stringList, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return stringList.stream()
                .filter(s -> s != null && s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

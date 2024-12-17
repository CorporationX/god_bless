package school.faang.sprint_2.task_47298;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListOperations {
    static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        return numbers.stream()
            .distinct()
            .filter(num -> numbers.contains(sum - num))
            .map(num -> Arrays.asList(num, sum - num))
            .peek(Collections::sort)
            .collect(Collectors.toSet());
    }

    static List<String> getCountry(Map<String, String> country) {
        return country.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(Map.Entry::getValue)
            .toList();
    }

    static List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
            .filter(str -> str.startsWith(String.valueOf(letter)))
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }

    static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
            .map(Integer::toBinaryString)
            .toList();
    }

    static List<String> filterAndSortByLength(List<String> strings, String regex) {
        return strings.stream()
            .filter(str -> Pattern.compile("[" + regex + "]+").matcher(str).matches())
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }
}

package school.faang.task_47351streamapi2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterSortByLength(List<String> strings, char symbol) {
        return strings.stream()
                .filter(filStr -> filStr.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        Pattern pattern = Pattern.compile("[" + Pattern.quote(alphabet) + "]+");

        return strings.stream()
                .filter(s -> pattern.matcher(s).find())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

package school.faang.task_58036;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        return filterNonNullSet(numbers).stream()
                .filter(number -> numbers.contains(sum - number) && sum - number < number)
                .map(number -> List.of(number, sum - number))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        if (countries == null) {
            return Collections.emptyList();
        }
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char letter) {
        return filterNonNullList(strings).stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> nums) {
        return filterNonNullList(nums).stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        if (alphabet == null) {
            return Collections.emptyList();
        }
        String regex = String.format("[%s]+", alphabet);

        return filterNonNullList(strings).stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static <T> List<T> filterNonNullList(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream().filter(Objects::nonNull).toList();
    }

    private static <T> Set<T> filterNonNullSet(Set<T> set) {
        if (set == null) {
            return Collections.emptySet();
        }
        return set.stream().filter(Objects::nonNull).collect(Collectors.toSet());
    }
}

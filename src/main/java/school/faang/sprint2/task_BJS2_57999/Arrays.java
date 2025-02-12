package school.faang.sprint2.task_BJS2_57999;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Arrays {
    public static Map<Integer, Integer> findUniqueSumOfNumbersEqualTarget(Set<Integer> set, int target) {
        Map<Integer, Integer> hasNumbers = new HashMap<>();

        set.forEach(val -> {
            if (hasNumbers.containsKey(target - val)) {
                hasNumbers.put(target - val, val);
            } else if (!hasNumbers.containsKey(val)) {
                hasNumbers.put(val, null);
            }
        });

        return hasNumbers.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Set<String> getCitySortedByCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedStringsStartsWithChar(List<String> strings, char start) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(start)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryStrings(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> getFilteredByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches("^[" + alphabet + "]+$"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

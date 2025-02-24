package school.faang.task_47302;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskManager {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int target) {
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);

        return numbers.stream()
                .filter(num -> set.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> onlyCapitals(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortedByLengthAndSymbol(List<String> list, char symbol) {
        return list.stream()
                .filter(str -> str.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> numbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return list.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

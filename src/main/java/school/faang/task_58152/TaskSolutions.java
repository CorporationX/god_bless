package school.faang.task_58152;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaskSolutions {

    public static Set<List<Integer>> findPairs(@NonNull Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num < sum - num && numbers.contains(sum - num))
                .map(num -> List.of(num, sum - num))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(@NonNull List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortByLength(@NonNull List<String> strings, String alphabet) {
        Pattern pattern = Pattern.compile("[" + alphabet + "]+");
        return strings.stream()
                .filter(s -> pattern.matcher(s).matches())
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}

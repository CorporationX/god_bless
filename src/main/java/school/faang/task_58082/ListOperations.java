package school.faang.task_58082;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findPair(@NonNull Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> number != sum - number && numbers.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countries) {
        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortFilteredRows(@NonNull List<String> rows, char keyChar) {
        return rows.stream()
                .filter(row -> row.startsWith(String.valueOf(keyChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterRowsByAlphabet(@NonNull List<String> rows, @NonNull String alphabet) {
        String regex = "^[" + alphabet + "]+$";
        return rows.stream()
                .filter(row -> row.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

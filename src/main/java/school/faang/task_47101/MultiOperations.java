package school.faang.task_47101;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class MultiOperations {
    public static Set<List<Integer>> findPairs(@NonNull List<Integer> numbers, int sum) {
        if (sum == 0) {
            throw new IllegalArgumentException("sum is null");
        }
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
                .filter(number -> set.contains(sum - number))
                .map(number -> Arrays.asList(number, sum - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countries) {
        if (countries.isEmpty()) {
            throw new IllegalArgumentException("countries cannot be empty");
        }
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(@NonNull List<String> strings, char letter) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("strings cannot be empty");
        }
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("symbol is not a letter");
        }
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(@NonNull List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("numbers cannot be empty");
        }
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(@NonNull List<String> strings, @NonNull String alphabet) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("strings cannot be empty");
        }
        if (alphabet.isBlank()) {
            throw new IllegalArgumentException("alphabet cannot be blank");
        }
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

package school.faang.task_bjs247238;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTrainingTasks {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int targetNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.stream()
                .filter(number -> uniqueNumbers.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filerAndSortStrings1(List<String> strings, char character) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> updateToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> filerAndSortStrings2(List<String> strings, String characters) {
        String regex = "[" + characters + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }
}

package school.faang.bjs2_72367;

import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;

public class StreamUtils {
    public static List<Map.Entry<Integer, Integer>> findUniquePairsFromTarget(
            @NonNull Set<Integer> numbers,
            int target) {
        return numbers.stream()
                .filter(number -> numbers.contains(target - number))
                .filter(number -> number < target - number)
                .map(number -> Map.entry(number, target - number))
                .toList();
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countryByCapital) {
        return countryByCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStringsByPrefix(@NonNull List<String> strings, char prefix) {
        return strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == prefix)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortStringsByAlphabet(@NonNull List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

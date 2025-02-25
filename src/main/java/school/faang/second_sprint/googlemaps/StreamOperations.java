package school.faang.second_sprint.googlemaps;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findPairs(@NonNull Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> filtrateCapitals(@NonNull Map<String, String> countryWithCapitals) {
        return countryWithCapitals.values().stream()
                .sorted(Comparator.naturalOrder())
                .toList();

    }

    public static List<String> filtrateByLengthStartsWithCharacter(@NonNull List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.charAt(0) == character)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> turn10to2(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filtrateByLengthContainingAlphabet(
            @NonNull List<String> strings,
            @NonNull String alphabet) {

        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}

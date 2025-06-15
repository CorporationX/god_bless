package school.faang.stream_api2;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<Integer[]> findPairs(Set<Integer> nums, int target) {
        return nums.stream()
                .filter(x -> x < target - x && nums.contains(target - x))
                .map(x -> new Integer[]{x, Math.abs(target - x)})
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterStringsByStartChar(@NonNull List<String> strings,
                                                        char ch) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(@NonNull List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringsByAlphabet(List<String> strings, String alphabet) {
        alphabet.equals("^[abcdefghijklmnopqrstuvwxyz]+$");
        return strings.stream()
                .filter(str -> str.matches("^[abcdefghijklmnopqrstuvwxyz]+$"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}

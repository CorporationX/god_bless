package school.faang.sprint_2.task_47630;

import java.util.*;
import java.util.stream.Collectors;

public class Operation {
    public static List<int[]> findPairs(int[] numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : numbers) {
            int complement = target - num;
            if (seen.contains(complement)) {
                result.add(new int[]{Math.min(num, complement), Math.max(num, complement)});
            }
            seen.add(num);
        }
        return result;
    }

    public static List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        return Optional.ofNullable(countryCapitalMap)
                .map(map -> map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(Map.Entry::getValue)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return Optional.ofNullable(strings)
                .map(list -> list.stream()
                        .filter(str -> str != null && !str.isEmpty() && str.startsWith(String.valueOf(startChar)))
                        .sorted()
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .filter(list -> !list.isEmpty())
                .map(list -> list.stream()
                        .map(Integer::toBinaryString)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        String regex = "^[ " + alphabet + "].*";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted()
                .collect(Collectors.toList());
    }
}

package school.faang.sprint_2.task_47630;

import java.util.*;
import java.util.stream.Collectors;

public class Operation {
    public static List<int[]> findPairs(int[] numbers, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int num : numbers) {
            int complement = target - num;
            if (seen.getOrDefault(complement, 0) > 0) {
                result.add(new int[]{Math.min(complement, num), Math.max(complement, num)});
                seen.put(complement, seen.get(complement) - 1);
            }
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return result.stream()
                .sorted((a, b) -> {
                    int firstComparison = Integer.compare(a[0], b[0]);
                    return firstComparison != 0 ? firstComparison : Integer.compare(a[1], b[1]);
                })
                .collect(Collectors.toList());
    }


    public static List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        return Optional.ofNullable(countryCapitalMap)
                .map(map -> new ArrayList<>(map.values()))
                .filter(capitals -> !capitals.isEmpty())
                .map(capitals -> capitals.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return Optional.ofNullable(strings)
                .map(list -> list.stream()
                        .filter(str -> str != null && !str.isEmpty() && str.charAt(0) == startChar)
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
        Set<Character> alphabetSet = Optional.ofNullable(alphabet)
                .map(a -> a.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toSet()))
                .orElse(Collections.emptySet());

        return Optional.ofNullable(strings)
                .map(list -> list.stream()
                        .filter(str -> str != null && !str.isEmpty() && alphabetSet.contains(str.charAt(0)))
                        .sorted()
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}

package school.faang.task_47464;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperations {
    public static List<int[]> findUniquePairs(List<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(num1 -> numbers.stream()
                        .filter(num2 -> num1 < num2 && num1 + num2 == targetSum)
                        .map(num2 -> new int[]{num1, num2}))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> capitalList(Map<String, String> countries) {
        if (countries == null || countries.isEmpty()) {
            return Collections.emptyList();
        }

        return countries.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortString(List<String> strings, char startChar) {
        if (strings.isEmpty()) {
            return Collections.emptyList();
        }

        return strings.stream()
                .filter(str -> str.charAt(0) == startChar)
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
    }

    public static List<String> listOfNumberToListOfBinary(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return  Collections.emptyList();
        }

        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSortStrings(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null) {
            throw new IllegalArgumentException("List of strings and alphabet cannot be empty");
        }

        Set<Character> alphabetSet = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}

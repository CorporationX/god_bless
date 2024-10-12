package school.faang.streamTwo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    public static Map<Integer, Integer> findPairs(List<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num))
                .filter(num -> num < sum - num)
                .collect(Collectors.toMap(
                                num -> num,
                                num -> sum - num,
                                (num1, num2) -> num1
                        )
                );
    }

    public static List<String> sortCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == startChar)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        Set<Character> alphabetSet = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabetSet.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
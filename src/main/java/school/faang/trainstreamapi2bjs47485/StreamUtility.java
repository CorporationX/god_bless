package school.faang.trainstreamapi2bjs47485;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtility {
    public static List<List<Integer>> findUniquePairs(List<Integer> numbers,
                                                      int target) {
        Set<Integer> seen = new HashSet<>();

        return numbers.stream()
                .flatMap(number -> {
                    int complement = target - number;
                    if (seen.contains(complement)) {
                        return Stream.of(List.of(Math.min(number, complement),
                                Math.max(number, complement)));
                    } else {
                        seen.add(number);
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings,
                                                    char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings,
                                                       String alphabet) {
        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> allowedChars.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}

package faang.school.godbless.sprint_2.task_47372;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int givenNumber) {
        checkObjectForNull(numbers);

        return numbers.stream()
                .filter(n -> numbers.contains(givenNumber - n))
                .map(n -> List.of(n, givenNumber - n))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndReturnCapitals(Map<String, String> countriesAndCapitals) {
        checkObjectForNull(countriesAndCapitals.keySet());
        checkObjectForNull(countriesAndCapitals.values());

        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByChar(List<String> strings, char c) {
        checkObjectForNull(strings);

        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryFormat(List<Integer> numbers) {
        checkObjectForNull(numbers);

        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAlphabeticallyAndSortByLength(List<String> strings, String alphabet) {
        checkObjectForNull(strings);
        checkObjectForNull(alphabet);

        return strings.stream()
                .filter(s -> {
                    for (char c : s.toCharArray()) {
                        if (!alphabet.contains(String.valueOf(c))) {
                            return false;
                        }
                    }
                    return true;
                })
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static void checkObjectForNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }
}

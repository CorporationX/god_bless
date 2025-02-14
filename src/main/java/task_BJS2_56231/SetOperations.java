package task_BJS2_56231;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> number != targetNumber - number && numbers.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

}

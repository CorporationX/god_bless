package school.faang.sprinttwo.streamapi2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations2 {
    public static Set<Set<Integer>> unicPairOfNumbers(Set<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a + b == target && a < b)
                        .map(b -> Set.of(a, b)))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalOfCountry(Map<String, String> capital) {
        return capital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }




}

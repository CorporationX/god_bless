package school.faang.streamApi.training_two;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }
}

package school.faang.stream_api_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquePairsFinder {
    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num -> num != target - num && numbers.contains(target - num))
                .map(num -> Arrays.asList(num, target - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }
}
package school.faang.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class UniquePairs {
    final static int TARGET_SUM = 7;

    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(numbers);
        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(findPairs(numbers, TARGET_SUM));

    }

}

package school.faang.streamapitwo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniquePairsFinder {

    public static List<Pair> findUniquePairs(List<Integer> numbers, int targetSum) {
        Set<Integer> seen = new HashSet<>();

        return numbers.stream()
                .filter(number -> {
                    int complement = targetSum - number;
                    boolean isPair = seen.contains(complement);
                    seen.add(number);
                    return isPair;
                })
                .map(number -> {
                    int complement = targetSum - number;
                    return new Pair(Math.min(number, complement), Math.max(number, complement));
                })
                .distinct()
                .collect(Collectors.toList());
    }
}

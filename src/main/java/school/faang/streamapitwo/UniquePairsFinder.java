package school.faang.streamapitwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePairsFinder {

    public static List<Pair> findUniquePairs(List<Integer> numbers, int targetSum) {
        Set<Pair> pairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer number : numbers) {
            int complement = targetSum - number;
            if (seen.contains(complement)) {
                pairs.add(new Pair(Math.min(number, complement), Math.max(number, complement)));
            }
            seen.add(number);
        }

        return new ArrayList<>(pairs);
    }
}

package StreamApi.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePairs {
    public static List<int[]> findUniquePairs(List<Integer> numbers, int sum) {
        Set<Integer> found = new HashSet<>();
        Set<String> processedPairs = new HashSet<>();
        List<int[]> results = new ArrayList<>();

        for (int a : numbers) {
            int b = sum - a;
            if (found.contains(b) && !processedPairs.contains(a + "," + b) && !processedPairs.contains(b + "," + a)) {
                processedPairs.add(a + " + " + b);
                results.add(new int[]{
                        Math.min(a, b), Math.max(a, b)
                });
            }
            found.add(a);
        }

        return results;
    }
}

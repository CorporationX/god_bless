package school.faang.bjs_70946;

import java.util.*;

public class UniquePairs {
    public static List<int[]> findUniquePairs(Set<Integer> numbers, int target) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : numbers) {
            int complement = target - num;
            if (numbers.contains(complement) && complement != num && !seen.contains(num)) {
                result.add(new int[]{Math.min(num, complement), Math.max(num, complement)});
                seen.add(num);
                seen.add(complement);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        List<int[]> pairs = findUniquePairs(numbers, target);

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }
}

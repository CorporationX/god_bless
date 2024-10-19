package school.faang.streamAPI;

import java.util.*;

public class UniquePairs {
    public static List<int[]> findUniquePairs(int[] numbers, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<int[]> pairs = new HashSet<>();

        for (int number : numbers) {
            int complement = target - number;
            if (seen.contains(complement)) {
                pairs.add(new int[]{Math.min(number, complement), Math.max(number, complement)});
            }
            seen.add(number);
        }

        return new ArrayList<>(pairs);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<int[]> result = findUniquePairs(numbers, target);
        System.out.println("Unique pairs:");
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}

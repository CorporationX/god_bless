package school.faang.streamapi2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        findUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6).forEach(arr -> System.out.printf("%d : %d%n", arr[0], arr[1]));
    }

    private static List<int[]> findUniquePairs(Set<Integer> nums, int target) {
        return nums.stream()
                .flatMap(i -> nums.stream().filter(j -> i + j == target && i < j)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }
}

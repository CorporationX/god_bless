package school.faang.practice_stream_api_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        System.out.println(Operations.findUniquePairsWithSpecificSum1(nums, target));
    }
}

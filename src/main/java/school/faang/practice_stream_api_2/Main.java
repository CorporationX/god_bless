package school.faang.practice_stream_api_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println(Operations.findUniquePairsWithSpecificSum3(nums, target));
    }
}

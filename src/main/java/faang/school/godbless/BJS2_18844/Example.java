package faang.school.godbless.BJS2_18844;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public void reverse(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        Collections.reverse(list);

        int[] reversed = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.arraycopy(reversed, 0, nums, 0, nums.length);
    }
}

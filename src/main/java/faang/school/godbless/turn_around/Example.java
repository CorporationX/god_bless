package faang.school.godbless.turn_around;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {
    public List<Integer> reverse(Integer[] nums) {
        List<Integer> numsToList = Arrays.asList(nums);
        Collections.reverse(numsToList);
        return List.of(numsToList.toArray(nums));
    }
}

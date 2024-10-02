package turn_around;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class Example {
    public List<Integer> reverse(List<Integer> nums) {
        nums = nums.stream().sorted().toList();
        List<Integer> result = new ArrayList<>();
        for (int i = nums.size(); i > 0; i--) {
            result.add(nums.get(i - 1));
        }
        return result;
    }
}

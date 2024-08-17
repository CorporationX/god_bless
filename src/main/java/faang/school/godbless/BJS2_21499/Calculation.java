package faang.school.godbless.BJS2_21499;

import java.util.List;

public class Calculation {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++){
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}

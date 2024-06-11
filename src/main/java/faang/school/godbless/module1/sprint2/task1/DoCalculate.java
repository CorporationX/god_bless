package faang.school.godbless.module1.sprint2.task1;

import java.util.List;

public class DoCalculate {
    public static int calculate(List<Integer> nums,
                                Calculator<Integer,Integer,Integer> calculator) throws IllegalArgumentException{
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}

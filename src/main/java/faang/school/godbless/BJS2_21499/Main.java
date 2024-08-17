package faang.school.godbless.BJS2_21499;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,10,33,16,1);
        System.out.println(product(nums));
        System.out.println(sum(nums));

    }

    public static int product(List<Integer> nums){
        return Calculation.calculate(nums, (a,b) -> a * b);
    }

    public static int sum(List<Integer> nums){
        return Calculation.calculate(nums, (a,b) -> a + b);
    }
}

package faang.school.godbless.calculus;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.compute(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //3628800
        System.out.println(product(nums));
        //55
        System.out.println(sum(nums));

        List<Integer> nums2 = List.of(1, -1, 1, 0, 1, 1);
        //0
        System.out.println(product(nums2));
        //3
        System.out.println(sum(nums2));
    }
}

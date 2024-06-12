package faang.school.godbless;

import lombok.NonNull;

import java.util.List;

public class Application<T> {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    @NonNull
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int num : nums) {
            if (num == nums.get(0)) {
                continue;
            }

            result = (int) calculator.calculate(num, result);
        }
        return result;
    }

    @NonNull
    public static int product(List<Integer> nums) {
        return calculate(nums, (num, result) -> (int) result * (int) num);
    }

    @NonNull
    public static int sum(List<Integer> nums) {
        return calculate(nums, (num, result) -> (int) result + (int) num);
    }
}
package faang.school.godbless.Calculator;

import lombok.NonNull;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums1 = List.of(4, 3, 5, 1);
        System.out.println(sum(nums1));
        System.out.println(product(nums1));

        List<Integer> nums2 = List.of();
        System.out.println(sum(nums2));
        System.out.println(product(nums2));

        List<Integer> nums3 = List.of(0, 0, 0);
        System.out.println(sum(nums3));
        System.out.println(product(nums3));
    }

    public static int calculate(List<Integer> in, Calculator<Integer, Integer, Integer> calculator) {
        if (in.isEmpty()) {
            throw new IllegalArgumentException("Список пустой");
        }
        int result = in.get(0);
        for (int i = 1; i < in.size(); i++) {
            result = calculator.workCalculator(result, in.get(i));
        }
        return result;
    }

    public static int sum(@NonNull List<Integer> nums) {
        return calculate(nums, (i1, i2) -> i1 + i2);
    }

    public static int product(@NonNull List<Integer> nums) {
        return calculate(nums, (i1, i2) -> i1 * i2);
    }
}

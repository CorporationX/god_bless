package school.faang.tasks_45668;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 3);
//        nums.set(0, null);
        int sum = calculate(nums, (a, b) -> a + b);
        System.out.println(sum);
        int product = calculate(nums, (a, b) -> a * b);
        System.out.println(product);
    }
    public static int calculate(List<Integer> nums, Calculator calculator) {
        return nums.stream()
//                .filter(num -> num != null)
                .reduce((a, b) -> calculator.calc(a, b))
                .orElseThrow(() -> new IllegalArgumentException("список пуст"));
    }
}

package faang.school.godbless.BJS221454;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = List.of(1, 2, 3, 4);

        System.out.println(product(listNumbers));
        System.out.println(sum(listNumbers));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Numbers not found.");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calcul(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (n1, n2) -> n1 * n2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (n1, n2) -> n1 + n2);
    }
}

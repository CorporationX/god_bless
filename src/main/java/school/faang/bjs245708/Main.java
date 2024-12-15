package school.faang.bjs245708;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        product();
        sum();
    }

    public static void product() {
        System.out.println(calculate(
                List.of(1, 2, 3, 4, 5, 6),
                ((a, b) -> a * b)
        ));
    }

    public static void sum() {
        System.out.println(calculate(
                List.of(1, 2, 3, 4, 5, 6),
                (Integer::sum)
        ));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }
}

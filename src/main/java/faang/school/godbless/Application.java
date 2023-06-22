package faang.school.godbless;
import java.util.List;

public class Application {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || calculator == null)
            throw new IllegalArgumentException("Invalid input");

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static void main(String... args) {
        List<Integer> numbers = List.of(2, 4, 6, 8);

        int productResult = product(numbers);
        int sumResult = sum(numbers);

        System.out.println("Product: " + productResult);
        System.out.println("Sum: " + sumResult);
    }
}

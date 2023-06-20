package Calculator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Application {
    public static void main(String... args) {
        int x = calculate(List.of(1, 2, 3, 4, 5), Application::sum);
        int y = calculate(List.of(5, 5, 8), Application::power);

        System.out.println("Сумма: " + x);
        System.out.println("Произведение: " + y);
    }

    public static int calculate(List<Integer> nums, @NotNull Calculator<Integer> calculator) {
        return calculator.calculate(nums);
    }

    public static int power(@NotNull List<Integer> nums) {
        return nums.stream().reduce(1, (a, b) -> a * b);
    }

    public static int sum(@NotNull List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}

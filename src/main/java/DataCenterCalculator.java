import java.util.List;

public class DataCenterCalculator {
    public static double sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }

    public static double product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

    private static int calculate(List<Integer> numbers, Calculator<Integer> calculator) {
        if (numbers == null || numbers.isEmpty() || calculator == null) {
            throw new IllegalArgumentException("numbers is empty or null or calculator is null");
        }

        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = calculator.calculate(result, numbers.get(i));
        }

        return result;
    }
}

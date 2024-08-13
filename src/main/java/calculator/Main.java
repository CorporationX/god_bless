package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate(List.of(1,2,3,4,5), Integer::sum));
        System.out.println(calculate(List.of(1.5,2.5,3.5,4.5,5.5), (a,b) -> a * b));
    }

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не должен быть пустой");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.performOperation(result, nums.get(i));
        }
        return result;
    }
}

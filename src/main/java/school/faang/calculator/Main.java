package school.faang.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbersList = List.of(5, 5, 5);

        System.out.println(sum(numbersList));
        System.out.println(product(numbersList));
    }

    public static int calculate(List<Integer> nums,
                                Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List can`t be empty");
        }
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.mathematicalOperation(result, nums.get(i));
        }
        return result;
    }

    public static Integer sum(List<Integer> integerList) {
        return calculate(integerList, (a, b) -> a + b);
    }

    public static Integer product(List<Integer> integerList) {
        return calculate(integerList, (a, b) -> a * b);
    }
}

package faang.school.godbless.lambda.calculator;

import java.util.List;
import java.util.Optional;

public class Main {
    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        Optional<List<T>> optionalList = Optional.ofNullable(nums); // можно коммент насчет этой строчки, гуд или по другому можно написать?
        if (optionalList.isPresent()) {
            if (nums.isEmpty()) {
                throw new IllegalArgumentException("empty list");
            }
            T result = nums.get(0);
            for (int i = 0; i < nums.size() - 1; i++) {
                result = calculator.calculate(result, nums.get(i + 1));
            }
            return result;
        }
        throw new IllegalArgumentException("list is null!");
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(product(List.of(1, 3, 5, 7, 9)));
        System.out.println(sum(List.of(1, 2, 3, 4, 5)));
        System.out.println(product(null));
    }
}

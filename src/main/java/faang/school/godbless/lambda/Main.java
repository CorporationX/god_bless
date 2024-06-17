package faang.school.godbless.lambda;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int calculate(@NonNull List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        return numbers.stream().reduce((x, y) -> calculator.calculate(x, y))
                .orElseThrow(() -> new IllegalArgumentException("Проверьте переданные параметры"));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber * secondNumber));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber + secondNumber));
    }

    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int product = product(listOfNumbers);
        int sum = sum(listOfNumbers);
        System.out.println(product);
        System.out.println(sum);
    }
}

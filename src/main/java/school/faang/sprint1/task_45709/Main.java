package school.faang.sprint1.task_45709;


import java.util.Arrays;
import java.util.List;

public class Main {
    @FunctionalInterface
    public interface Calculator {
        int calculate(int a, int b);
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Сумма чисел: " + CalculatorAction.sum(numbers));
        System.out.println("Произведение чисел: " + CalculatorAction.product(numbers));


    }
}

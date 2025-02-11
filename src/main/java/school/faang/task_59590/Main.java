package school.faang.task_59590;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> bigNumbers = List.of(Integer.MAX_VALUE, 2);
        boolean sumSuccess = false;
        boolean productSuccess = false;

        try {
            int sumResult = Process.sum(numbers);
            System.out.println("Сумма: " + sumResult);
            sumSuccess = true;

            int productResult = Process.product(numbers);
            System.out.println("Произведение: " + productResult);
            productSuccess = true;

        } catch (ArithmeticException e) {
            System.err.println("Ошибка (ArithmeticException): " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка (IllegalArgumentException): " + e.getMessage());
        }

        try {
            int sumBig = Process.sum(bigNumbers);
            System.out.println("Sum of big numbers: " + sumBig);
        } catch (ArithmeticException | IllegalArgumentException e) {
            sumSuccess = false;
            System.err.println("Ошибка при сложении больших чисел: " + e.getMessage());
        }
        try {
            int productBig = Process.product(bigNumbers);
            System.out.println("Product of big numbers: " + productBig);
        } catch (ArithmeticException | IllegalArgumentException e) {
            productSuccess = false;
            System.err.println("Ошибка при умножении больших чисел: " + e.getMessage());
        }

        if (sumSuccess && productSuccess) {
            System.out.println("Вычисления для обычных чисел выполнены успешно.");
        } else {
            System.out.println("Вычисления для обычных чисел не были полностью выполнены из-за переполнения.");
        }

        try {
            List<Integer> emptyList = List.of();
            System.out.println("Sum of empty list: " + Process.sum(emptyList));
            System.out.println("Product of empty list: " + Process.product(emptyList));
        } catch (NoSuchElementException e) {
            System.out.println("Empty value: " + e.getMessage());
        }

        List<Integer> singleElementList = List.of(10);
        System.out.println("Sum of single element list: " + Process.sum(singleElementList));
        System.out.println("Product of single element list: " + Process.product(singleElementList));

        List<Integer> negativeNumbers = Arrays.asList(-1, 2, -3, 4, -5);
        System.out.println("Sum of negative numbers: " + Process.sum(negativeNumbers));
        System.out.println("Product of negative numbers: " + Process.product(negativeNumbers));
    }
}
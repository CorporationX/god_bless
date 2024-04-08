package faang.school.godbless.calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Не понял как обрабатывать случаи, когда сумма или произведение больше максимального int.
        // Возможно можно как-то сделать плавающий return type с помощью дженериков, но не особо понял как.
        System.out.println(product(List.of(8, 9)));
        System.out.println(sum(List.of(1, 2, 3)));

        System.out.println(productLong(List.of(1L, 2L, 3L)));
    }

    public static int calculateInteger(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        return nums.stream()
                .reduce(calculator::operation)
                .get();
    }

    public static int product(List<Integer> nums) {
        return calculateInteger(nums, ((num1, num2) -> num1 * num2));
    }

    public static int sum(List<Integer> nums) {
        return calculateInteger(nums, (Integer::sum));
    }

    // Решил сделать Calculator на основе дженериков, но как будто делаю что-то не так.
    // Если мы хотим теперь работать с Long, а не с Integer, то для это нужно целые отдельные методы делать.
    // Хотя возможно так и нужно.
    public static long calculateLong(List<Long> nums, Calculator<Long> calculator) throws IllegalArgumentException {
        return nums.stream()
                .reduce(calculator::operation)
                .get();
    }

    public static long productLong(List<Long> nums) {
        return calculateLong(nums, ((num1, num2) -> num1 * num2));
    }
}
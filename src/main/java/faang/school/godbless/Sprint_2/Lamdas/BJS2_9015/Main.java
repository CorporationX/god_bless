package faang.school.godbless.Sprint_2.Lamdas.BJS2_9015;

//1. Создать подходящий функциональный интерфейс Calculator, который должен иметь метод, принимающий два значения
// одного типа и возвращающий результат применения к ним какой-либо операции. Какого типа получится тогда результат?
//2. Реализовать метод, который принимает список чисел, а также объект Calculator, который и будет операцией,
// которую нужно применить к элементам в списке.
//public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException
//3. Реализовать методы, которые используют calculate и передают в неё нужную лямбду.
//Произведение чисел во всем списке public static int product(List<Integer> nums);
//Сумма чисел всего списка public static int sum(List<Integer> nums).

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Вычисляем произведение чисел в списке
        int productResult = product(numbers);
        System.out.println("Произведение чисел в списке: " + productResult);

        // Вычисляем сумму чисел в списке
        int sumResult = sum(numbers);
        System.out.println("Сумма чисел в списке: " + sumResult);
    }
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым");
        }
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }
    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }
}

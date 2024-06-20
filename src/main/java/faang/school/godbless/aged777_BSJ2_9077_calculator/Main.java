package faang.school.godbless.aged777_BSJ2_9077_calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*

    Условия задачи:

Вы работаете разработчиком в дата центре Google и создаёте систему сбора аналитики использования ресурсов дата-центра.
Вам нужно сделать её достаточно гибкой и масштабируемой для будущих новых сценариев, поэтому вы решаете использовать
лямбды и функциональные интерфейсы.

Создать подходящий функциональный интерфейс Calculator, который должен иметь метод, принимающий два значения одного
типа и возвращающий результат применения к ним какой-либо операции. Какого типа получится тогда результат?

Реализовать метод, который принимает список чисел, а также объект Calculator, который и будет операцией, которую нужно
применить к элементам в списке.

public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException

Реализовать методы, которые используют calculate и передают в неё нужную лямбду.

Произведение чисел во всем списке public static int product(List<Integer> nums);

Сумма чисел всего списка public static int sum(List<Integer> nums).

     */
    private static final Calculator<Integer, Integer, Integer> calculator_sum = (a, b) -> (a + b); // сложение Integer
    private static final Calculator<Integer, Integer, Integer> calculator_mul = (a, b) -> (a * b); // умножение Integer
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(11);
        nums.add(12);
        nums.add(13);
        nums.add(14);

        System.out.println(calculate(nums, calculator_sum));
        System.out.println(calculate(nums, calculator_mul));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer, Integer, Integer> calculator) throws IllegalArgumentException {
        int result = 0; // если действие - сложение
        if (calculator.equals(calculator_mul)) result = 1; // если действие - умножение

        for (Integer currentNumber : nums) {
            result = calculator.calculate(result, currentNumber);
        }

        return result;
    }

}

package faang.school.godbless.sprint_3.task_8;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String... args) {
        List<Integer> integers = List.of(5,79);
        calculate(integers, ((x, y) -> x + y), 0);
        calculate(integers, ((x, y) -> x * y), 1);
    }

    public static void calculate(List<Integer> numbers, Calculator calculator, int startValue) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        } else {
            int result = startValue;
            for (int i = 0; i < numbers.size(); i++) {
                result = calculator.apply(result, numbers.get(i));
            }
            System.out.println(result);
        }
    }
}
/*1. Создать подходящий функциональный интерфейс Calculator, который должен иметь метод,
принимающий два значения одного типа и возвращающий результат применения к ним какой-либо операции. Какого типа получится тогда результат?

2. Реализовать метод, который принимает список чисел, а также объект Calculator,
который и будет операцией, которую нужно применить к элементам в списке.*/

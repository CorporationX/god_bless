package faang.school.godbless.lambdas.task_7;

import java.util.List;
import static faang.school.godbless.lambdas.task_7.util.DataCalculator.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        System.out.println("Ожидаемый результат при сложении: " + 15);
        System.out.println("Результат сложения: " + sum(nums));
        System.out.println();
        System.out.println("Ожидаемый результат при умножении: " + 120);
        System.out.println("Результат умножения: " + product(nums));
    }
}
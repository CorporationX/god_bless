package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Calculator<Integer> proizv = (firstNum, secondNum) -> firstNum * secondNum;
    public static Calculator<Integer> sum = (firstNum, secondNum) -> firstNum + secondNum;

    public static int calculate(List<Integer> numberList, Calculator calculator) throws IllegalArgumentException {
        int multiplication = 1;
        for (Integer number : numberList) {
            multiplication = calculator.calc(multiplication, number);
        }
        ;
        return multiplication;
    }

    public static void product(List<Integer> numberList) {
        System.out.println(calculate(numberList, proizv));
    }

    public static void sum(List<Integer> numberList) {
        System.out.println(calculate(numberList, sum));
    }
}

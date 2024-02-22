package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static Calculator<Integer> product = (firstNum, secondNum) -> firstNum * secondNum;
    public static Calculator<Integer> sum = Integer::sum;

    public static int calculate(List<Integer> numberList, Calculator calculator) throws IllegalArgumentException {
        if (numberList.isEmpty() || numberList == null) {
            System.out.println("The list is empty");
            throw new IllegalArgumentException();
        }
        int multiplication = 1;
        for (Integer number : numberList) {
            multiplication = calculator.calc(multiplication, number);
        }
        return multiplication;
    }

    public static void product(List<Integer> numberList) {
        System.out.println(calculate(numberList, product));
    }

    public static void sum(List<Integer> numberList) {
        System.out.println(calculate(numberList, sum));
    }
}

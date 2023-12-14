package Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator summing = ((numberOne, numberTwo) -> numberOne + numberTwo);
        Calculator multiplication = ((numberOne, numberTwo) -> numberOne * numberTwo);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(245);
        numbers.add(-23);

        Integer resultOfSum = calculate(numbers, summing);
        Integer resultOfMiltiplication = calculate(numbers, multiplication);

        System.out.println(resultOfSum);
        System.out.println(resultOfMiltiplication);
    }


    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        //проверяем что в списке есть числа
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Добавьте числа для операции");
        }
        Integer temp = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            temp = calculator.operation(temp, nums.get(i));
        }
        return temp;
    }
}

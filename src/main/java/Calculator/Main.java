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

        Integer temp = 0;
        for (Integer number : nums) {
            //добавляем первый элемент в temp
            if (nums.indexOf(number) == 0) {
                temp = number;
            } else {
                //Проверяем что результат умещается в диапазоне значений Integer
                if (number > Integer.MAX_VALUE - temp || number < Integer.MIN_VALUE + temp) { //(Скорее всего запись не самая оптимальная)
                    throw new ArithmeticException("Слишком большое/маленькое итоговое значение)");
                }
                temp = calculator.operation(temp, number);
            }
        }
        return temp;
    }
}

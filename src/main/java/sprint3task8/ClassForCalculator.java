package sprint3task8;

import java.util.List;

public class ClassForCalculator {
    public static int calculate
            (List<Integer> nums, Calculator calculator)
            throws IllegalArgumentException {
        //Необходимо получить в итоге одно число, а не list.
        //2 3 4 5 6  получается 140 (150).
        //не так рядком 2 5 9...140 , а сразу одно единственное число 140.
        int temp = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            temp = calculator.calculateIt(temp, nums.get(i));
            //temp = nums.get(i)*nums.get(i-1);
            //nums.get(i)= temp;
            //задумка про то, чтобы получить list с переумноженными и пересложенными
            //друг с другом переменными, но тут надо не так.
        }
        return temp;
    }
    public static int product(List<Integer> nums) {
        //Произведение чисел во всем списке
        return calculate(nums, (p1, p2) -> p1 * p2);
    }

    public static int sum(List<Integer> nums) {
        //Сумма чисел всего списка
        return calculate(nums, (p1, p2) -> p1 + p2);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(4, 1, 2, -1, 1);
        System.out.println(sum(list));
        System.out.println(product(list));
    }
}

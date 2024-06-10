package faang.school.godbless.module1.sprint2.task1;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        List<Integer> list = List.of(1, 2, 3, 4);
        System.out.println(product(list));
        System.out.println(sum(list));
    }

    public static int product(List<Integer> nums) {
        Calculator<Integer, Integer, Integer> calculator = (x, y) -> x * y;
        return DoCalculate.calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator<Integer, Integer, Integer> calculator = Integer::sum;
        return DoCalculate.calculate(nums, calculator);
    }

}

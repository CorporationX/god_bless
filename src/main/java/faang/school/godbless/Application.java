package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
        List<Integer> numbers = List.of(2, 3, 4);
        int sum = product(numbers);
        System.out.println("Sum of numbers: " + sum); // Output should be 9
    }
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException{
        Integer result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = (Integer) calculator.calc(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums){

        Calculator addInteger = (Number t1, Number t2) -> {
            return (Integer) (t1.intValue() + t2.intValue());
        };

        return calculate(nums,  addInteger);
    }
}
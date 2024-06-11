package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
//Реализовать методы, которые используют calculate и передают в неё нужную лямбду.
//Произведение чисел во всем списке public static int product(List<Integer> nums);
//Сумма чисел всего списка public static int sum(List<Integer> nums).
public class Counter {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("Need more elements");
        }
        Integer summ = calculator.operation(nums.get(0),nums.get(1));
        for(int i =2;i<nums.size();i++) {
            summ=calculator.operation(summ,nums.get(i));
        }
        return summ;
    }
    public static int product(List<Integer> nums) {
        return calculate(nums,(a,b)->a*b);
    }
    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
    public static void main(String[] args) {
        List<Integer> example = new ArrayList<>();
        example.add(1);
        example.add(2);
        example.add(3);
        example.add(4);
        System.out.println(product(example));
        System.out.println(sum(example));
    }
}

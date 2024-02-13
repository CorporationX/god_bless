package faang.school.godbless.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> intNumbers = new ArrayList<>(List.of(4, 8, 7, 16));
    static List<Double> doubleNumbers = new ArrayList<>(List.of(1.5, 8.2, 2.0, 9.3));

    public static void main(String[] args) {
        System.out.println(productIntegers(intNumbers));
        System.out.println(productDoubles(doubleNumbers));
        System.out.println(sumDoubles(doubleNumbers));
        System.out.println(sumIntegers(intNumbers));
    }

    public static double calculateDoubles(List<Double> nums, Calculator<Double> calculator) throws IllegalArgumentException {
        double result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int calculateIntegers(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int productIntegers(List<Integer> nums) {
        return calculateIntegers(nums, (number1, number2) -> number1 * number2);
    }

    public static double productDoubles(List<Double> nums) {
        return calculateDoubles(nums, (number1, number2) -> number1 * number2);
    }

    public static int sumIntegers(List<Integer> nums) {
        return calculateIntegers(nums, Integer::sum);
    }

    public static double sumDoubles(List<Double> nums) {
        return calculateDoubles(nums, Double::sum);
    }
}
package faang.school.godbless.Calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        int answer = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            answer = calculator.calculate(answer, nums.get(i));
        }
        return answer;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}

package faang.school.godbless.BJS2_9296;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int res1 = product(List.of(1, 2, 3));
        int res2 = sum(List.of(1, 2, 2));

        System.out.println(res1 + "______" + res2);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        checkIfNumsList(nums);
        if (calculator == null) throw new IllegalArgumentException();

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstNum, secondNum) -> firstNum * secondNum);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (firstNum, secondNum) -> firstNum + secondNum);
    }

    private static void checkIfNumsList(List<Integer> nums) {
        if (nums.isEmpty() || nums == null || nums.size() < 1) throw new IllegalArgumentException();
    }
}

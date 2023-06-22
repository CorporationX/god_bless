package sprint3task8;
import java.util.List;

public class ClassForCalculator {
    public static int calculate
            (List<Integer> nums, Calculator calculator)
            throws IllegalArgumentException {
        //2 3 4 5 6   140  2 5 9...140 140
        int temp = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            temp = calculator.calculateIt(temp, nums.get(i));
            //temp = nums.get(i)*nums.get(i-1);
            //nums.get(i)= temp;
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

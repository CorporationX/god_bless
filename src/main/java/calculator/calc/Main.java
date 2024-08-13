package calculator.calc;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubles = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0);

        System.out.println(productInt(list));

        System.out.println(productDouble(doubles));
    }

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {

        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List nums is empty");
        } else {
            T result = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                result = calculator.calc(result, nums.get(i));
            }
            return result;
        }

    }

    public static int productInt(List<Integer> nums) {

        return calculate(nums, (n1, n2) -> n1 * n2);

    }

    public static int sumInt(List<Integer> nums) {

        return calculate(nums, (n1, n2) -> n1 + n2);

    }

    public static double productDouble(List<Double> nums) {

        return calculate(nums, (n1, n2) -> n1 * n2);

    }

    public static double sumDouble(List<Double> nums) {

        return calculate(nums, (n1, n2) -> n1 + n2);

    }
}

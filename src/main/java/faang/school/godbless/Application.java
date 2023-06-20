package faang.school.godbless;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String... args) {

    }
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Table is empty");
        }
        VectorJoiner<String> vectorJoiner = vector -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                stringBuilder.append(", ").append(vector.get(i));
            }
            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder res = new StringBuilder(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++) {
                res.append("\n").append(vectorJoiner.join(matrix.get(i)));
            }
            return res.toString();
        };

        return matrixJoiner.join(table);

    }

      public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.consume(res, nums.get(i));
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}

package school.faang.task_45692;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(null, 1, 2, 3, 4, 5, null, 6, 7, 8, 9, 10, null);

        log.info("sum: {}", sum(nums));
        log.info("product: {}", product(nums));
    }

    public static int calculate(@NonNull List<Integer> nums, Calculator<Integer> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        int index = 0;
        while (index < nums.size()) {
            if (nums.get(index) != null) {
                break;
            }
            index++;
        }

        int result = nums.get(index++);
        while (index < nums.size()) {
            Integer num = nums.get(index);
            if (num != null) {
                result = calculator.calculate(result, num);
            }
            index++;
        }
        return result;
    }

    public static int sum(@NonNull List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(@NonNull List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

}

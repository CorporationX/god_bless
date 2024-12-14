package school.faang.task_45692;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        return nums.stream()
                .filter(Objects::nonNull)
                .reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException("All elements in the list are null"));
    }

    public static int sum(@NonNull List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(@NonNull List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

}

package school.faang.bjs2_71406;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(17, 25, 30);

        int sumResult = IntegerCalculator.sum(nums);
        int productResult = IntegerCalculator.product(nums);

        log.info("Сумма: {}", sumResult);
        log.info("Произведение: {}", productResult);
    }
}

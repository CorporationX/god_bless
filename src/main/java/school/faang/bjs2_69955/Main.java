package school.faang.bjs2_69955;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        log.info("Product result is: {}", CalculateProcessor.product(nums));
        log.info("Sum result is: {}", CalculateProcessor.sum(nums));
    }
}
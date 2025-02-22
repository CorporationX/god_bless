package school.faang.calculator;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Runner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        log.info("sum: {}", CalculatorProcessor.sum(numbers));
        log.info("Product: {}", CalculatorProcessor.product(numbers));

    }

}

package calculator;

import java.util.List;
import java.util.function.BiFunction;
import java.util.logging.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    private static final String CALCULATING_THE_SUM = "Calculating the sum...";
    private static final String SUM_CALCULATED = "Sum calculated: ";
    private static final String CALCULATING_THE_MULTIPLY = "Calculating the multiply...";
    private static final String MULTIPLY_CALCULATED = "Multiply calculated: ";

    public static int calculate(List<Integer> numbers, BiFunction<Integer, Integer, Integer> operation) {

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = operation.apply(result, numbers.get(i));
        }
        return result;
    }

    public static void sum(List<Integer> numbers) {
        logger.info(CALCULATING_THE_SUM);
        int result = calculate(numbers, Integer::sum);
        logger.info(SUM_CALCULATED + result);
    }

    public static void multiply(List<Integer> numbers) {
        logger.info(CALCULATING_THE_MULTIPLY);
        int result = calculate(numbers, (a, b) -> a * b);
        logger.info(MULTIPLY_CALCULATED + result);
    }
}

package bjs2_57133;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

class CalculatorTest {
    List<Integer> testData = List.of(3, 5, 8, 10);

    @Test
    void calculateEmptyArray() {
        // Arrange
        Random rnd = new Random();
        int initialValue = rnd.nextInt();
        int expectedResult = initialValue;

        // Act
        Integer result = Main.calculate(
                initialValue,
                List.of(),
                (x, y) -> -1);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void calculateSum() {
        // Arrange
        Integer initialValue = 0;
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = initialValue;
            for (Integer num : testData) {
                expectedResult += num;
            }

            return expectedResult;
        };

        // Act + Assert
        runTest(initialValue, Integer::sum, expectedResultCalculator);
    }

    @Test
    void calculateProduct() {
        // Arrange
        Integer initialValue = 1;
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = initialValue;
            for (Integer num : testData) {
                expectedResult *= num;
            }

            return expectedResult;
        };

        // Act + Assert
        runTest(initialValue, (x, y) -> x * y, expectedResultCalculator);
    }

    @Test
    void calculateMinus() {
        // Arrange
        Integer initialValue = 0;
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = initialValue;
            for (Integer num : testData) {
                expectedResult -= num;
            }

            return expectedResult;
        };

        // Act + Assert
        runTest(initialValue, (x, y) -> x - y, expectedResultCalculator);
    }

    private void runTest(
            Integer initialValue,
            Calculator<Integer> calculator,
            Supplier<Integer> expectedResultCalculator) {
        // Arrange
        int expectedResult = expectedResultCalculator.get();

        // Act
        Integer result = Main.calculate(initialValue, testData, calculator);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
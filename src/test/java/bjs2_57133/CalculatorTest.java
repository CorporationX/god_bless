package bjs2_57133;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

class CalculatorTest {
    List<Integer> testData = List.of(3, 5, 8, 10);

    @Test
    void calculateEmptyArray() {
        // Arrange
        int expectedResult = 0;

        // Act
        Integer result = Main.calculate(
                List.of(),
                (x, y) -> -1);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void calculateSum() {
        // Arrange
        int initialValue = 0;
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = initialValue;
            for (Integer num : testData) {
                expectedResult += num;
            }

            return expectedResult;
        };

        // Act + Assert
        runTest(Integer::sum, expectedResultCalculator);
    }

    @Test
    void calculateProduct() {
        // Arrange
        int initialValue = 1;
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = initialValue;
            for (Integer num : testData) {
                expectedResult *= num;
            }

            return expectedResult;
        };

        // Act + Assert
        runTest((x, y) -> x * y, expectedResultCalculator);
    }

    @Test
    void calculateMinus() {
        // Arrange
        Supplier<Integer> expectedResultCalculator = () -> {
            int expectedResult = testData.get(0);

            Iterator<Integer> iskipFirstIerator = testData.stream().skip(1).iterator();
            while (iskipFirstIerator.hasNext()) {
                expectedResult -= iskipFirstIerator.next();
            }

            return expectedResult;
        };

        // Act + Assert
        runTest((x, y) -> x - y, expectedResultCalculator);
    }

    private void runTest(
            Calculator<Integer> calculator,
            Supplier<Integer> expectedResultCalculator) {
        // Arrange
        int expectedResult = expectedResultCalculator.get();

        // Act
        Integer result = Main.calculate(testData, calculator);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
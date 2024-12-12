package school.faang.task_45677;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationProcessorTest {
    @Test
    void productTest() {
        int actualResult = OperationProcessor.product(List.of(1, 2, 3, 4));

        assertEquals(24, actualResult);
    }

    @Test
    void productWithEmptyListTest() {
        int actualResult = OperationProcessor.product(List.of());

        assertEquals(0, actualResult);
    }

    @Test
    void productWithOneElementTest() {
        int actualResult = OperationProcessor.product(List.of(1));

        assertEquals(1, actualResult);
    }

    @Test
    void productWithNegativesElementsTest() {
        int actualResult = OperationProcessor.product(List.of(-1, 2, 3));

        assertEquals(-6, actualResult);
    }

    @Test
    void sumTest() {
        int actualResult = OperationProcessor.sum(List.of(1, 2, 3, 4));

        assertEquals(10, actualResult);
    }

    @Test
    void sumWithEmptyListTest() {
        int actualResult = OperationProcessor.sum(List.of());

        assertEquals(0, actualResult);
    }

    @Test
    void sumWithOneElementTest() {
        int actualResult = OperationProcessor.sum(List.of(1));

        assertEquals(1, actualResult);
    }

    @Test
    void sumWithNegativesElementsTest() {
        int actualResult = OperationProcessor.sum(List.of(-1, -2));

        assertEquals(-3, actualResult);
    }
}
package school.faang.task_45677;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationProcessorTest {
    public static final int PRODUCT_RESULT = 24;
    public static final int SUM_RESULT = 10;

    @Test
    void productTest() {
        int actualResult = OperationProcessor.product(List.of(1, 2, 3, 4));

        assertEquals(PRODUCT_RESULT, actualResult);
    }

    @Test
    void sumTest() {
        int actualResult = OperationProcessor.sum(List.of(1, 2, 3, 4));

        assertEquals(SUM_RESULT, actualResult);
    }
}
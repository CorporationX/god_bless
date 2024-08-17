package faang.school.godbless.lambda.exceptions;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionUtilTest {

    @Test
    void testWithErrorHandling_ArithmeticException() {
        Supplier<Integer> action = () -> {
            System.out.println("Try to execute action...");
            return 2 / 0;
        };
        ExceptionHandler<Integer> exceptionHandler = throwable -> {
            System.out.println("Exception handled: " + throwable.getClass().getSimpleName() + ", returning default value 0");
            return 0;
        };

        assertEquals(0, ExceptionUtil.withErrorHandling(action, exceptionHandler));
    }

    @Test
    void testWithErrorHandling_NoExceptions() {
        Supplier<String> action = () -> {
            System.out.println("Try to execute action...");
            return "string1" + "string2";
        };
        ExceptionHandler<String> exceptionHandler = throwable -> {
            System.out.println("Exception handled: " + throwable.getClass().getSimpleName() + ", returning default value with empty string'");
            return "";
        };

        assertEquals("string1string2", ExceptionUtil.withErrorHandling(action, exceptionHandler));
    }
}
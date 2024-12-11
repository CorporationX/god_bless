package school.faang.bjs_46193;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class ErrorHandlerTest {

    @Test
    void withErrorHandlingWithError() {
        Double actual = ErrorHandler.withErrorHandling(
                () -> AnyService.division(4.0, 0.0),
                e -> {
                    System.out.println(e.getMessage());
                    return 0.0;
                }
        );

        Assertions.assertEquals(0.0, actual);
    }

    @Test
    void withErrorHandling() {
        Double actual = ErrorHandler.withErrorHandling(
                () -> AnyService.division(4.0, 2.0),
                e -> {
                    System.out.println(e.getMessage());
                    return 0.0;
                }
        );
        Assertions.assertEquals(2.0, actual);
    }

    public static class AnyService {
        public static double division(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException();
            }

            return a / b;
        }
    }
}
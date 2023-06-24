package sprint3.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint3.lambda.handler.ExceptionHandler;
import sprint3.lambda.handler.TaskHandler;

public class TaskHandlerTest {
    private final ExceptionHandler<String> errorHandler = (ex) -> {
        String error = "�� ������� ������������� ����� � ������ (%s). ���������� ������ �� ���������";
        System.out.printf(error, ex.getClass().getSimpleName());
        return "default";
    };
    @Test
    public void shouldReturnResultOfAction() {
        String expectedValue = "100";
        int value = 100;

        String obtainedValue = TaskHandler.withErrorHandling(() -> Integer.toString(value), errorHandler);

        Assertions.assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldThrowException() {
        String expectedResult = "default";
        int value = 1337;

        String obtainedValue = TaskHandler.withErrorHandling(() -> String.valueOf(value).substring(0, 5), errorHandler);

        Assertions.assertEquals(expectedResult, obtainedValue);
    }
}

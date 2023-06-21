package errors;

import faang.school.godbless.errors.ErrorHandler;
import faang.school.godbless.errors.ExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionHandlerTest {
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void withoutErrorHandling() {
    Supplier<Integer> action = () -> {
      System.out.println("Successful");
      return 5;
    };

    ExceptionHandler<Integer> exceptionHandler = (e) -> {
      System.out.println("Error");
      return 0;
    };

    ErrorHandler.withErrorHandling(action, exceptionHandler);
    assertEquals("Successful", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();
  }

  @Test
  public void withErrorHandling() {
    Supplier<Integer> action = () -> {
      int[] nums = {1, 2, 3};
      nums[4] = 5;
      return 5;
    };

    ExceptionHandler<Integer> exceptionHandler = (e) -> {
      System.out.println("Error");
      return 0;
    };

    ErrorHandler.withErrorHandling(action, exceptionHandler);

    assertEquals("Error", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();
  }
}

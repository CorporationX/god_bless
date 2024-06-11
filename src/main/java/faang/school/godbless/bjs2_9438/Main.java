package faang.school.godbless.bjs2_9438;

import java.util.function.Supplier;

public class Main {

  private static final String ANSWER = "Ответ: ";
  private static final String ERROR_OCCURRED = "Произошла ошибка: ";

  public static void main(String[] args) {

    Supplier<String> supplier = () -> {
      int i = 10;
      int j = 0;
      return ANSWER + (i / j);
    };

    ExceptionHandler exceptionHandler = exception -> ERROR_OCCURRED + exception.getMessage();

    String result = withErrorHandling(supplier, exceptionHandler);
    System.out.println(result);

  }

  private static String withErrorHandling(Supplier<String> supplier, ExceptionHandler exceptionHandler) {
    try {
      return supplier.get();
    } catch (Exception e) {
      return exceptionHandler.handle(e);
    }
  }

}

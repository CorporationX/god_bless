package faang.school.godbless.BJS2_5165;

import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    Supplier<String> supplier1 = () -> "OK";
    Supplier<String> supplier2 = () -> {
      throw new RuntimeException();
    };
    ExceptionHandler<String> exceptionHandler = (e) -> "Default";

    System.out.println(withErrorHandling(supplier1, exceptionHandler));
    System.out.println(withErrorHandling(supplier2, exceptionHandler));
  }

  public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
    try {
      return supplier.get();
    } catch (Exception e) {
      return exceptionHandler.handle(e);
    }
  }
}

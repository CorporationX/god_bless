package faang.school.godbless.errorHandler;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import static faang.school.godbless.errorHandler.ServiceCallHelper.withErrorHandling;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
       Integer result = withErrorHandling(Main::callRemoteService, exception -> {
        log.info(exception.getMessage());
        return 666;
      });
       log.info("Result: " + result);
    }
  }

  private static int callRemoteService() {
    Random random = new Random();
    int result = random.nextInt(10);
    if (result % 2 == 0) {
      throw new RuntimeException("Непредвиденная ошибка");
    } else {
      return result;
    }
  }
}

package faang.school.godbless.bjs2_13334;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

  private static final long TIME_OUT = 15;
  private static final String GET_VALUE_INTERRUPTED_EXCEPTION = "Получение значения было прервано. ";
  private static final String GET_VALUE_EXECUTION_EXCEPTION = "Что то произошло при получении значения. ";
  private static final String GET_VALUE_TIMEOUT_EXCEPTION = "Врем ожидания получении истекло. ";
  private static final String TERMINATION_TIMEOUT_EXCEPTION = "Врем ожидания истекло. ";
  private static final String ALL_OPERATION_COMPLETED = "Все операции были выполнены!";
  private static final String RESULT_COLLECTION_PAYMENT = "Результат сбора платежа: ";
  private static final String RESULT_SENDING_ANALYTICS = "Результат отправки аналитики: ";

  public static void main(String[] args) {
    MasterCardService masterCardService = new MasterCardService();
    doAll(masterCardService);
  }

  private static void doAll(MasterCardService masterCardService) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<Integer> future = executorService.submit(masterCardService::collectPayment);

    CompletableFuture<Integer> completableFuture =
        CompletableFuture.supplyAsync(masterCardService::sendAnalytics, executorService);

    System.out.println(RESULT_COLLECTION_PAYMENT + completableFuture.join());
    System.out.println(RESULT_SENDING_ANALYTICS + getFutureValue(future));

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(TERMINATION_TIMEOUT_EXCEPTION + e);
    }

    System.out.println(ALL_OPERATION_COMPLETED);

  }

  private static <T> T getFutureValue(Future<T> future) {
    try {
      return future.get(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(GET_VALUE_INTERRUPTED_EXCEPTION + e);
    } catch (ExecutionException e) {
      throw new RuntimeException(GET_VALUE_EXECUTION_EXCEPTION + e);
    } catch (TimeoutException e) {
      throw new RuntimeException(GET_VALUE_TIMEOUT_EXCEPTION + e);
    }
  }

}

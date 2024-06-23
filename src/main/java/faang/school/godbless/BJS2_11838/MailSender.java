package faang.school.godbless.BJS2_11838;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
  private static final int THREADS = 5;
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    for (int i = 0 ; i < THREADS; i++) {
      int start = i * 200;
      int end = start + 200;
      executorService.execute(new SenderRunnable(start, end));
    }
    executorService.shutdown();
    try {
      executorService.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

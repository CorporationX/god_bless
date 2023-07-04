package faang.school.godbless.telegram;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int REQUESTS_COUNT_LIMIT = 5;
  public static void main(String[] args) {
    TelegramBot bot = new TelegramBot(REQUESTS_COUNT_LIMIT, LocalDateTime.now());
    ExecutorService executorService = Executors.newFixedThreadPool(REQUESTS_COUNT_LIMIT);

    for (int i = 0; i < 20; i++) {
      int messageNumber = i;
      Runnable task = () -> bot.sendMessage("Message №" + (messageNumber + 1));
      executorService.submit(task);
    }

    executorService.shutdown();

    try {
      executorService.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Completed");
  }
}

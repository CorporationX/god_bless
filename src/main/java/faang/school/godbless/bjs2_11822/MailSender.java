package faang.school.godbless.bjs2_11822;

import static faang.school.godbless.ColorScheme.RESET;

import faang.school.godbless.ColorScheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.SneakyThrows;

public class MailSender {
  private static final int POOL_SIZE = 5;
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 200;
  private static final String ALL_EMAIL_WERE_SENT = "Вcе письма были разосланы";

  @SneakyThrows
  public static void main(String[] args) {
    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < POOL_SIZE; i++) {
      final int start = i * MAX_VALUE + MIN_VALUE;
      final int end = (i + MIN_VALUE) * MAX_VALUE;
      final int id = new Random().nextInt(ColorScheme.values().length);
      Thread thread = new Thread(new SenderRunnable(start, end, id));
      thread.start();
      threads.add(thread);
    }

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    System.out.println(RESET.getColor() + ALL_EMAIL_WERE_SENT);
  }

}

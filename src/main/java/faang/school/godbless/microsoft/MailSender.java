package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MailSender {
  private static final int COUNT_PER_MAIL = 200;
  private static List<Number> getUsersMail(int start, int end) {
    return IntStream.rangeClosed(start, end)
        .boxed().collect(Collectors.toList());
  }

  private static List<Thread> getThreadList(int count) {
    List<Thread> threads = new ArrayList<>();
    List<Number> mails = getUsersMail(0, 999);

    for (int i = 0; i < count; i++) {
      int startIndex = i * COUNT_PER_MAIL;
      int endIndex = startIndex + COUNT_PER_MAIL;

      Thread thread = new Thread(new SenderRunnable(mails, startIndex, endIndex));
      threads.add(thread);
    }

    return threads;
  }

  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = getThreadList(5);

    for (Thread thread : threads) {
      thread.start();
    }

    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println("All messages have been sent");
  }
}

package faang.school.godbless.BJS2_5708;

import java.util.List;

public class MailSender {
  public static void main(String[] args) {
    List<Thread> threads = List.of(new Thread(new SenderRunnable(0, 200)),
      new Thread(new SenderRunnable(200, 400)),
      new Thread(new SenderRunnable(400, 600)),
      new Thread(new SenderRunnable(600, 800)),
      new Thread(new SenderRunnable(800, 1000)));

    threads.forEach(Thread::start);
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
  }
}

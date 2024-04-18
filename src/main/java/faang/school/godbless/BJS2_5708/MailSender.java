package faang.school.godbless.BJS2_5708;

import java.util.List;

public class MailSender {
  public static void main(String[] args) {
    List<Thread> threads = List.of(new Thread(new SenderRunnable(100, 200)),
      new Thread(new SenderRunnable(200, 300)),
      new Thread(new SenderRunnable(400, 500)),
      new Thread(new SenderRunnable(500, 600)),
      new Thread(new SenderRunnable(600, 700)));

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

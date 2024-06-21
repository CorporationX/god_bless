package faang.school.godbless.sprint2.microsoft;

/**
 * @author Evgenii Malkov
 */
public class MailSender {
  private static final int POOL_SIZE = 5;
  private static final int MAIL_SIZE = 100;

  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[POOL_SIZE];
    for (int i = 0; i < POOL_SIZE; i++) {
      int startIndex = i * MAIL_SIZE / POOL_SIZE + 1;
      int endIndex = startIndex + MAIL_SIZE / POOL_SIZE;
      SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
      threads[i] = new Thread(sender);
      threads[i].start();
    }

    for (Thread t : threads) {
      t.join();
    }
    System.out.println("Финиш");
  }
}

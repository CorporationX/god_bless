package school.faang.multithreading.microsoft;

public class MailSender {

  public static void main(String[] args) throws InterruptedException {

    int totalMessages = 1000;
    int threadsCounts = 5;
    int batchSize = totalMessages / threadsCounts;

    Thread[] threads = new Thread[threadsCounts];

    for (int i = 0; i < threadsCounts; i++) {
      int startIndex = i * batchSize;
      int endIndex = (i + 1) * batchSize;
      threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
      threads[i].start();
    }

    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println("All messages were sent");
  }

}

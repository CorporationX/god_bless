package school.faang.workInTheMicrosoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MailSender {
  public static void main(String[] args) throws InterruptedException {
    List<Message> messages = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 1000; i++) {
      String title = "сообщение #" + (i + 1);
      String randomContent = String.valueOf(random.nextInt(1000));

      messages.add(new Message(title, randomContent));
    }

    int numberOfThreads = 5;
    int numberOfMessages = 200;

    Thread[] threads = new Thread[numberOfThreads];

    for (int i = 0; i < numberOfThreads; i++) {
      int startIndex = i * numberOfMessages;
      int endIndex = startIndex + numberOfMessages - 1;

      SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex, messages);

      threads[i] = new Thread(senderRunnable);
      threads[i].start();
    }

    for (int i = 0; i < numberOfThreads; i++) {
      threads[i].join();
    }

    System.out.println("Все сообщения отправленны!!!");
  }
}

package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        int numberOfMessagesPerThread = 200;
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= numberOfThreads; i++) {
            Thread thread = new Thread(new SenderRunnable(numberOfMessagesPerThread * (i - 1),
                    numberOfMessagesPerThread * i - 1));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        System.out.println("Все 1000 писем успешно отправлены!");
        System.out.println(String.format("Counter val = %s", Counter.count));
    }
}

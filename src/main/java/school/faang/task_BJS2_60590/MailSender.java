package school.faang.task_BJS2_60590;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        final int amoutOfMessage = 1000;
        final int amoutOfThreads = 5;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < amoutOfThreads; i++) {
            int startIndex = (i * (amoutOfMessage / amoutOfThreads)) + 1;
            int endIndex = (i + 1) * (amoutOfMessage / amoutOfThreads) + 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            executor.submit(senderRunnable);
        }

        executor.shutdown();

        System.out.println("All messages are sended");
    }
}
package work_at_microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int messagesPerThread = 200;

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int startIndex = (i * messagesPerThread) + 1;
            int endIndex = startIndex + messagesPerThread - 1;
            executorService.submit(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdownNow();

        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All messages sent successfully.");
    }
}

package work_at_microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        int messagesPerThread = 200;

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int startIndex = (i * messagesPerThread) + 1;
            int endIndex = startIndex + messagesPerThread - 1;
            executorService.submit(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdownNow();

        while (!executorService.isTerminated()) {
            // instead join. Wait until all tasks are completed.
        }

        System.out.println("All messages sent successfully.");
    }
}

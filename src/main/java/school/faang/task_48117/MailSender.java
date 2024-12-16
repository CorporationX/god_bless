package school.faang.task_48117;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            executorService.submit(new SenderRunnable(start, end));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Все письма отправлены!");
    }
}

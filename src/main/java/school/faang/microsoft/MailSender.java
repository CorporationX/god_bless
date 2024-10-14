package school.faang.microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            service.submit(new SenderRunnable(start, end));
        }

        service.shutdown();

        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("принудительное завершение!");
            service.shutdownNow();
        }

        System.out.println("Все письма отправлены!");
    }
}

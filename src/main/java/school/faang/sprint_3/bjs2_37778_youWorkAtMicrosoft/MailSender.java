package school.faang.sprint_3.bjs2_37778_youWorkAtMicrosoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int totalMessages = 1000000;
        int batchSize = totalMessages / THREADS_COUNT;

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            executor.execute(new SenderRunnable(start, end));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Программа завершена принудительно!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все письма отправлены!");
    }
}

package school.faang.microsoft_bjs2_91125;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int emailsPerThreads = TOTAL_MESSAGES / THREADS_COUNT;

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * emailsPerThreads;
            int end = (i + 1) * emailsPerThreads;
            executor.execute(new SenderRunnable(start, end));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершились за это время");
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения пренудительно прервано");
            Thread.currentThread().interrupt();
        }
        System.out.println("Все письма отправлены");
    }
}
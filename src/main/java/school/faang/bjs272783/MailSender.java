package school.faang.bjs272783;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int LETTERS_TOTAL = 100_000;
    private static final long AWAIT_TIMEOUT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 1; i <= THREAD_COUNT; i++) {
            int startIndex = i * (LETTERS_TOTAL / THREAD_COUNT);
            int endIndex = startIndex + (LETTERS_TOTAL / THREAD_COUNT);
            executor.submit(new SenderRunnable(startIndex, endIndex));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            } else {
                System.out.printf("Все %d писем отправлены", LETTERS_TOTAL);
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения было прервано");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
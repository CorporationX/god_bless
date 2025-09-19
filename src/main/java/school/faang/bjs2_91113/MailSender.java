package school.faang.bjs2_91113;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static void main(String[] args) {
        final int TOTAL_MAILS = 1000;
        final byte NUMBER_OF_THREADS = 5;
        final int MAILS_PER_THREAD = TOTAL_MAILS / NUMBER_OF_THREADS;

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executor.submit(new SenderRunnable(i * MAILS_PER_THREAD,  (i + 1) * MAILS_PER_THREAD));
        }
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package faang.school.godbless.Microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    private static final int MAX_TREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_TREAD);

        for (int i = 0; i < 5; i++) {
            executor.submit(new SenderRunnable(i * 200, (i + 1) * 200));
        }
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("All messages have been sent");
    }
}

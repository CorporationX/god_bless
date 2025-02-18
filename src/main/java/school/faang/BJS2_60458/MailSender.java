package school.faang.BJS2_60458;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    private static final int THREAD_MESSAGE = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = THREAD_MESSAGE / THREAD_COUNT;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;

            executor.submit(() -> {
                new SenderRunnable(start, end).run();
                latch.countDown();
            });
        }

        latch.await();
        executor.shutdown();
        System.out.println("Все письма отправлены!");

    }
}

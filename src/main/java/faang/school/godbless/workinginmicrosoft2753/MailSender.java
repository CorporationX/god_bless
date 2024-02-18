package faang.school.godbless.workinginmicrosoft2753;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {

    private static final int MAILS_QUANTITY = 1000;
    private static final int MAX_BATCH_SIZE = 200;
    private static final int THREADS_NEEDED = MAILS_QUANTITY / MAX_BATCH_SIZE;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_NEEDED);
        List<SenderRunnable> batches = new ArrayList<>();

        for (int i = 0; i < THREADS_NEEDED; i++) {
            int startIndex = i * MAX_BATCH_SIZE + 1;
            int endIndex = MAX_BATCH_SIZE * (i + 1);
            batches.add(new SenderRunnable(startIndex, endIndex));
        }

        batches.forEach(batch -> threadPool.submit(() -> batch.run()));
        threadPool.shutdown();
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All E-Mails have been sent to users!");
    }
}

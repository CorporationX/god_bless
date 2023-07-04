package faang.school.godbless.work_in_microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {

    private static final int THREAD_AMOUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = startIndex + BATCH_SIZE;

            executor.submit(() ->{
                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();
            });
        }
        executor.shutdown();
    }
}

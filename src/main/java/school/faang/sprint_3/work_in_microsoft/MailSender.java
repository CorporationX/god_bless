package school.faang.sprint_3.work_in_microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * batchSize;
            int end = (i + 1) * batchSize;
            threads [i] = new Thread(new SenderRunnable(startIndex,end));
            threads [i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            log.info("All messages sent");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

package school.faang.parallelism.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int THREAD_OPERATIONS = 1000;
    private static final int THREAD_POOL = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = THREAD_OPERATIONS / THREAD_POOL;

        Thread[] threads = new Thread[THREAD_POOL];

        for (int i = 0; i < THREAD_POOL; i++) {
            threads[i] = new Thread(new SenderRunnable(i * batchSize, (i + 1) * batchSize - 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("All 1000 letters were sent!");
    }
}

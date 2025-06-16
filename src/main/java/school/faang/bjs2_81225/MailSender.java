package school.faang.bjs2_81225;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGE = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGE / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            int startInd = i * batchSize;
            int endInd = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startInd, endInd));
            threads[i].start();
        }

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i].join();
        }

        log.info("Задачи успешно выполнены!");
    }
}

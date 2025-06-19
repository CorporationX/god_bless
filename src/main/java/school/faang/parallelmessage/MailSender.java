package school.faang.parallelmessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_COUNT = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(i * BATCH_COUNT, (i + 1) * BATCH_COUNT));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток main был прерван.");
            }
        }

        log.info("Все письма отправлены!");
    }
}

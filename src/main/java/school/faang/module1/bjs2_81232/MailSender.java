package school.faang.module1.bjs2_81232;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int EMAILS_TOTAL = 1000;
    private static final int THREADS_COUNT = 5;
    private static final int EMAILS_PER_THREAD = EMAILS_TOTAL / THREADS_COUNT;
    private static final String THREAD_NAME_PREFIX = "Поток:";
    private static final int EMAILS_START_INDEX = 1;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * EMAILS_PER_THREAD + EMAILS_START_INDEX;
            int end = start + EMAILS_PER_THREAD - 1;
            threads[i] = new Thread(new SenderRunnable(start, end), THREAD_NAME_PREFIX + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.warn("Main поток прерван во время ожидания потока {}", thread.getName());
                Thread.currentThread().interrupt();
            }

        }
        log.info("Все письма отправлены");
    }
}
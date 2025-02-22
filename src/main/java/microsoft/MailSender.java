package microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_EMAILS / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex), "Поток-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании завершения потока", e);
                Thread.currentThread().interrupt();
                return;
            }
        }

        log.info("Все письма отправлены.");
    }
}

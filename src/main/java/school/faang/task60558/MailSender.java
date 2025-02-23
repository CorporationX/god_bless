package school.faang.task60558;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final String SUCCESS_SEND_MESSAGE = "Все письма были отправлены";
    private static final int THREAD_AMOUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_AMOUNT];

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = (i + 1) * BATCH_SIZE;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Error threads join", e);
        }

        log.info(SUCCESS_SEND_MESSAGE);
    }
}

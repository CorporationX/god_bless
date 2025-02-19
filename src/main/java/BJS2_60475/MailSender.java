package BJS2_60475;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int MESSAGES_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * MESSAGES_COUNT / THREADS_COUNT;
            int endIndex = (i + 1) * MESSAGES_COUNT / THREADS_COUNT;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("Все сообщения отправлены");
    }
}

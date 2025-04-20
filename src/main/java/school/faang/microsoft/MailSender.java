package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int PACK_MESSAGE = 200;
    private static final int THREAD_COUNT = 5;
    private static final int READABILITY_DELTA = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * PACK_MESSAGE + READABILITY_DELTA;
            int endIndex = (i + 1) * PACK_MESSAGE;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Письмо отправлено");
    }
}
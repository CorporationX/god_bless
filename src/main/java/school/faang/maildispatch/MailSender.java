package school.faang.maildispatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_LETTERS = 1000;
    private static final int TREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int bachSize = TOTAL_LETTERS / TREADS_COUNT;
        Thread[] threads = new Thread[TREADS_COUNT];

        for (int i = 0; i < TREADS_COUNT; i++) {
            int start = i * bachSize;
            int end = (i + 1) * bachSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        log.info("All letters have been sent");
    }
}

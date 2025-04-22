package work.at.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = TOTAL_MESSAGES / THREAD_COUNT;
    private static int startIndex = 0;
    private static int endIndex = BATCH_SIZE;

    public static void main(String[] args) {
        Thread thread;
        for (int i = 0; i < THREAD_COUNT; i++) {
            thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
            startIndex = endIndex;
            endIndex += BATCH_SIZE;
        }
        log.info("All messages has ben successfully sent!");
    }
}

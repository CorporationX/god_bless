package work.at.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = TOTAL_MESSAGES / THREAD_COUNT;
    private static int startIndex = 0;
    private static int endIndex = BATCH_SIZE;
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Thread> threadsList = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threadsList.add(thread);
            thread.start();
            startIndex = endIndex;
            endIndex += BATCH_SIZE;
        }

        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        log.info("All {} messages has ben successfully sent!", MailSender.counter.get());
    }
}

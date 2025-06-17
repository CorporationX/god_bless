package school.faang.bjs2_81252;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int EMAILS_TOTAL = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int START_INDEX = 0;
    private static final int EMAILS_PER_THREAD = EMAILS_TOTAL / THREAD_COUNT;

    public static void main(String[] args) {
        try {
            int startIndex = START_INDEX;
            int endIndex = EMAILS_PER_THREAD;

            List<Thread> pool = new ArrayList<>(THREAD_COUNT);

            for (int i = 0; i < THREAD_COUNT; i++) {
                Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
                pool.add(thread);
                startIndex += EMAILS_PER_THREAD;
                endIndex += EMAILS_PER_THREAD;

                thread.start();
            }

            for (Thread thread : pool) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Thread is interrupted", e);
        }
    }
}

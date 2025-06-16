package school.faang.bjs2_81252;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int START_INDEX = 0;
    private static final int LIMIT_LETTERS = 200;

    public static void main(String[] args) {
        try {
            int startIndex = START_INDEX;
            int endIndex = LIMIT_LETTERS;

            List<Thread> pool = new ArrayList<>(THREAD_COUNT);

            for (int i = 0; i < THREAD_COUNT; i++) {
                Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
                pool.add(thread);
                startIndex += LIMIT_LETTERS;
                endIndex += LIMIT_LETTERS;

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

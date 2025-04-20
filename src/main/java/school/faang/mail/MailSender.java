package school.faang.mail;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_EMAILS = TOTAL_EMAILS / THREAD_COUNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_EMAILS;
            int endIndex = (i == THREAD_COUNT - 1) ? TOTAL_EMAILS : startIndex + BATCH_EMAILS;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.warn("Поток был прерван: {}", e.getMessage());
            }
        }
        log.info("Почта синхронизирована.");
    }
}

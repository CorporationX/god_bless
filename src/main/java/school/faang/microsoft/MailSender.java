package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Danil Pudovkin
 * @since 16.06.2025
 */
@Slf4j
public class MailSender {

    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int EMAILS_PER_THREAD = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) {
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            var startIndex = i * EMAILS_PER_THREAD;
            var endIndex = startIndex + EMAILS_PER_THREAD - 1;
            var thread = new Thread(new SenderRunnable(startIndex, endIndex), "Sender%d".formatted(i));
            thread.start();
            threads.add(thread);
        }
        try {
            for (var thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Основной поток | Произошло прерывание: {}", e.getMessage());
        }
    }
}

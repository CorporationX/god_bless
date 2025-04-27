package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static void main(String[] args) {
        final int TOTAL_MAILS = 1000;
        final int MAILS_PER_THREAD = 200;
        final int THREAD_COUNT = 5;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * MAILS_PER_THREAD;
            int end = (i == THREAD_COUNT - 1) ? TOTAL_MAILS : start + MAILS_PER_THREAD;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Поток был прерван: " + e.getMessage());
            }
        }

        System.out.println("\nВсе 1000 писем успешно отправлены!");
    }
}
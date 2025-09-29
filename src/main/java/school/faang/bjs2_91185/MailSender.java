package school.faang.bjs2_91185;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = Math.min((i + 1) * BATCH_SIZE, TOTAL_MESSAGES);

            Thread thread = new Thread(
                    new SenderRunnable(startIndex, endIndex),
                    "Sender-" + (i + 1)
            );

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Поток прерван: " + thread.getName());
            }
        }

        System.out.println("Все письма отправлены. Количество писем: " +
                TOTAL_MESSAGES);
    }
}
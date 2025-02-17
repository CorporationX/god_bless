package school.faang.microsoft;

import java.util.Arrays;

public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int TOTAL_MESSAGES_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGES_COUNT / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        Arrays.stream(threads)
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("Все письма отправлены!");
    }
}



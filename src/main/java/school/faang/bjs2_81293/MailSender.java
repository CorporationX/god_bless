package school.faang.bjs2_81293;

import lombok.SneakyThrows;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    @SneakyThrows
    public static void main(String[] args) {
        int threadSize = TOTAL_MESSAGES / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * threadSize;
            int end = (i + 1) * threadSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new InterruptedException("Меня прервали");
            }
        }

        System.out.println("Все письма отправлены");
    }
}

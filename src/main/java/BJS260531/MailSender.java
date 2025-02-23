package BJS260531;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MailSender {
    private static final int MESSAGES = 1000;
    private static final  int THREADS = 5;

    public static void main(String[] args) {
        int batchSize = MESSAGES / THREADS;
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("Письма отправлены ");
        } catch (InterruptedException e) {
            log.error("Поток был прерван{}", e.getMessage());
            Thread.currentThread().interrupt();
            log.info("Завершаем все потоки ");
            Arrays.stream(threads).forEach(Thread::interrupt);
        }
    }

}

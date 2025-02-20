package task_BJS2_60559;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MailSender {
    private static final int THREAD_QUANTITY = 5;
    private static final int MAIL_QUANTITY = 1000;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_QUANTITY];
        int batchSize = MAIL_QUANTITY / THREAD_QUANTITY;

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            int start = i * batchSize + 1;
            int end = (i + 1) * batchSize;

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                log.info("Thread: {} was interrupted", Thread.currentThread().getName());
            }
        });

        System.out.println("Все письма отправлены!");
    }
}

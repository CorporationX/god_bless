package school.faang.task_48926;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int NUMBER_OF_THREADS = 5;
    private static final int LIST_SIZE = 10;

    public static void main(String[] args) {

        int batchSize = LIST_SIZE / NUMBER_OF_THREADS;

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(batchSize * i + 1, batchSize * i + batchSize);
            Thread thread = new Thread(senderRunnable);
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                log.info("Поток был прерван: " + e.getMessage());
            }
        }

        System.out.println("******************************** Все письма отправлены ********************************");

    }
}

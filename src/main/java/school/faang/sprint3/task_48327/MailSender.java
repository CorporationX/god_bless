package school.faang.sprint3.task_48327;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int NUM_OF_MESSAGES = 1000;
    private static final int NUM_OF_THREADS = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_OF_THREADS];

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            threads[i] = new Thread(
                    new SenderRunnable(i * NUM_OF_MESSAGES / NUM_OF_THREADS, (i + 1) * NUM_OF_MESSAGES / NUM_OF_THREADS)
            );
            threads[i].start();
        }

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                log.error("Thread has been interrupted. Exception : {}", e.toString());
                return;
            }
        }

        log.info("All the {} messages have been sent successfully !", NUM_OF_MESSAGES);
    }
}

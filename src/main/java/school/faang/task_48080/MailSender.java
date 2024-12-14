package school.faang.task_48080;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int numberOfEmails = 1000;
        int numberOfThreads = 5;
        int batchSize = numberOfEmails / numberOfThreads;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * batchSize;
            int endIndex = startIndex + batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info("All messages have been sent");
    }
}

package school.faang.task_48080;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int numberOfEmails = 103;
        int numberOfThreads = 5;
        int batchSize = numberOfEmails / numberOfThreads;
        int remainingEmails = numberOfEmails % numberOfThreads;
        Thread[] threads = new Thread[numberOfThreads];

        int startIndex = 0;
        for (int i = 0; i < threads.length; i++) {
            int endIndex = startIndex + batchSize;

            if (i < remainingEmails) {
                endIndex++;
            }

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            startIndex = endIndex;
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
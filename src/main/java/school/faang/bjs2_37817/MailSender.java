package school.faang.bjs2_37817;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int messagesCount = 1_000;
        int threadAmount = 5;
        int batchSize = messagesCount / threadAmount;

        Thread[] threads = new Thread[threadAmount];

        for (int i = 0; i < threadAmount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("All messages have been sent!");
    }
}

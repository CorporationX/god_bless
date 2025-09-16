package school.faang.bjs2_89556;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int COUNT_THREAD = 5;
    private static final int COUNT_LETTER = 1000;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = COUNT_LETTER / COUNT_THREAD;

        Thread[] threads = new Thread[COUNT_THREAD];
        for (int i = 0; i < COUNT_THREAD; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
            log.info("Thread {} finished", thread.getName());
        }
        System.out.println("All letters have been sent");
    }
}

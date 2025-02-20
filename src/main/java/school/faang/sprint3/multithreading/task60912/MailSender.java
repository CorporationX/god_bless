package school.faang.sprint3.multithreading.task60912;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int NUMBER_THREADS = 5;
    private static final int NUMBER_LETTERS = 1000;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_THREADS; i++) {
            int startIndex = i * NUMBER_LETTERS / NUMBER_THREADS + 1;
            int endIndex = (i + 1) * NUMBER_LETTERS / NUMBER_THREADS;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("\nThread {}: ", thread.getName());
                log.warn(e.getMessage());
            }
        }
        System.out.println("\nAll letters were sent successfully!");
    }
}

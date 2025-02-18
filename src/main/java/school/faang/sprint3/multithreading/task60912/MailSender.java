package school.faang.sprint3.multithreading.task60912;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.info("\nThread {}: ", thread.getName());
                log.warn(e.getMessage());
            }
        }
        System.out.println("\nAll letters were sent successfully!");


    }
}

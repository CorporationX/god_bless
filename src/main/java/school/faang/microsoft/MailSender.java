package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int numOfThreads = 5;
        int batchSize = 200;
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= numOfThreads; i++) {
            int startIndex = batchSize * (i - 1);
            int endIndex = batchSize * i - 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread was interrupted", e);
            }
        }
        System.out.println("Все 1000 писем успешно отправлены!");
        System.out.println(String.format("Counter val = %s", Counter.count));
    }
}

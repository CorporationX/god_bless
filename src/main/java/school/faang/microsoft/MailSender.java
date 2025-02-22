package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int threadCount = 5;
        int mailCount = 1000;
        int sendCount = mailCount / threadCount;

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * sendCount + 1;
            int endIndex = (i == threadCount - 1) ? mailCount : (startIndex + sendCount - 1);
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Поток прерван: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
        }

        log.info("Все потоки завершены");
    }
}

package Multithreading.bc2017;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;

            executorService.submit(new SenderRunnable(startIndex, endIndex));
        }
        executorService.shutdown();
    }
}

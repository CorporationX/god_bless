package BJS2_11990;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            executor.submit(new Senderrunable(startIndex, startIndex + 200));
        }
        executor.shutdown();
    }
}

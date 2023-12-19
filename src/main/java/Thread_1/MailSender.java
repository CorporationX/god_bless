package Thread_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            if ((i + 1) % 200 == 0) {
                int finalI = i;
                executor.submit(() -> new SenderRunnable(finalI - 199, finalI).run());
            }
        }
        while (!executor.isTerminated()) {
            executor.shutdown();
        }
        System.out.println("All threads complete");
    }
}

package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        int batchSize = 200;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int startBatch = i * batchSize;
            Thread thread = new Thread(new SenderRunnable(startBatch, startBatch + batchSize));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("All threads have finished execution");
    }
}

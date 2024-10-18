package school.faang.multithreading.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for(int i = 1; i <= 5; i ++) {
            Thread thread = new Thread(new SenderRunnable(i * BATCH_SIZE - BATCH_SIZE, i * BATCH_SIZE));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Sending complete");
    }
}

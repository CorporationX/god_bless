package school.faang.multithreading.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for(int i = 1; i <= 1000; i ++) {
            if(i % BATCH_SIZE == 0) {
                Thread thread = new Thread(new SenderRunnable(i - BATCH_SIZE + 1, i));
                threads.add(thread);
                thread.start();
            }
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Sending complete");
    }
}

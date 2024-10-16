package dima.evseenko.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREADS_COUNT = 5;

    public void send() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(new SenderRunnable(i * 200 + 1, (i + 1) * 200));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All mail sent successfully");
    }
}

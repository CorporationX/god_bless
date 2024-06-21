package faang.school.godbless.YouWorkForMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int SIZE_BATCH = 200;
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int startIndex = i * SIZE_BATCH;
            int endIndex = startIndex + SIZE_BATCH;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            THREADS.add(thread);
        }

        for (Thread thread : THREADS) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("all messages sent");
    }
}

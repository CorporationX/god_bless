package faang.school.godbless.multithreading;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MESSAGE_BATCH_SIZE = 200;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * MESSAGE_BATCH_SIZE;
            int endIndex = startIndex + MESSAGE_BATCH_SIZE;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to join thread " + e);
            }
        });

        System.out.println("All messages sent");
    }
}


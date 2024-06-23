package faang.school.godbless.multithreading_parallelism.task_1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int startIndex = i * BATCH_SIZE;
            final int endIndex = startIndex + BATCH_SIZE;

            final Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

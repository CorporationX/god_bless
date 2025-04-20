package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {

    private static final int THREAD_COUNT = 5;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = (i + 1) * BATCH_SIZE;

            Thread newThread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(newThread);
            newThread.start();
            log.info("{} - started", newThread.getName());
        }

        threads.forEach(thread -> {
            try {
                thread.join();
                log.info("{} - joined", thread.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

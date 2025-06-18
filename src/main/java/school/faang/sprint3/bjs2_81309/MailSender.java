package school.faang.sprint3.bjs2_81309;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MailSender {
    public static final int THREAD_MAX_COUNT = 5;
    public static final int THREAD_BATCH = 200;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_MAX_COUNT);
        try {
            List<Integer> list = IntStream.range(1, 1000).boxed().toList();
            int batchesCount = list.size() / THREAD_BATCH;
            for (int i = 0; i <= batchesCount; i++) {
                int startIndex = i * THREAD_BATCH;
                int endIndex = startIndex + (i == batchesCount ? list.size() - startIndex : THREAD_BATCH);
                executor.submit(
                        new SenderRunnable(list.subList(startIndex, endIndex))
                );
            }
            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

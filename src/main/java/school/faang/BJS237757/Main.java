package school.faang.BJS237757;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadPools = 5;
        int batchSize = totalMessages / threadPools;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPools);
        for (int i = 0; i < threadPools; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            executorService.submit(() -> new SenderRunnable(start, end).run());
        }
        if (!executorService.awaitTermination(threadPools, TimeUnit.SECONDS)) {
            System.out.println("Все задачи выполнены!");
            executorService.shutdown();
        }
    }
}

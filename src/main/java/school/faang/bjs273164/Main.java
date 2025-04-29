package school.faang.bjs273164;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int AWAIT_TIMEOUT = 5;
    private static final int THREAD_POOL_SIZE = 5;
    private static final int THREAD_SLEEP_TIME = 3000;

    public static void main(String[] args) {
        House lanesters = new House();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        IntStream.range(0, 15).forEach(i ->
            executorService.submit(() -> {
                User u = new User("User" + i, lanesters);
                u.joinHouse(lanesters);
                try {
                    Thread.sleep(THREAD_SLEEP_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                u.leaveHouse(lanesters);
            }));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
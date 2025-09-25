package school.faang.bjs2_90550;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int USER_COUNT = 10;
    private static final int THREAD_COUNT = 10;
    private static final int HOUSE_COUNT = 3;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) throws InterruptedException {

        House house = new House();
        executorService.submit(() -> {
            for (int i = 0; i < USER_COUNT; i++) {
                User user = new User("User" + i);
                user.joinHouse(house);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            }
        });
        executorService.shutdown();
        if (!executorService.awaitTermination(10, TimeUnit.MINUTES)) {
            executorService.shutdownNow();
        }
    }
}

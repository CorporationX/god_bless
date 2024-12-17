package school.faang.task_48303;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        executor.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                System.out.println("Еда в доме собрана!");
                executor.shutdown();
                try {
                    if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                        System.out.println("Принудительная остановка потоков...");
                        executor.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Программа была прервана.");
                    executor.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
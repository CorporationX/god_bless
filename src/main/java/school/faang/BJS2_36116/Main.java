package school.faang.BJS2_36116;

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
            System.out.println("Текущее количество собранной еды: " + house.getCollectedFood().size());

            if (house.isAllFoodCollected()) {
                executor.shutdown();
                System.out.println("Все еда собрана!");
            }
        }, 0, 2, TimeUnit.SECONDS);
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

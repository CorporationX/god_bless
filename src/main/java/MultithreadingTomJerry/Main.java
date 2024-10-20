package MultithreadingTomJerry;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CORE_POOL_SIZE = 5;
    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (int i = 0; i < CORE_POOL_SIZE; i++) {
            exec.scheduleAtFixedRate(() -> {
                house.collectFood();

                if (house.allFoodsCollected()) {
                    exec.shutdown();
                }
            }, 0, 30, TimeUnit.SECONDS);
        }
        if (house.allFoodsCollected()) {
            System.out.println("All foods collected!");
        }
    }
}

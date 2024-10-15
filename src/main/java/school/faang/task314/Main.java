package school.faang.task314;

import school.faang.task314.house.House;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int N_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.initialize();

        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(N_THREAD);

        for (int i = 0; i < N_THREAD; i++) {
            threadPool.scheduleWithFixedDelay(house::collectFood, 0, 1, TimeUnit.SECONDS);
        }
        while (!house.isAllFoodCollected()) {
            Thread.sleep(5000);
        }

        threadPool.shutdown();
        System.out.println("Еда в доме собрана!");
    }
}

package school.faang.sprint3.task_48467;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static school.faang.sprint3.task_48467.HouseSettings.THREAD_COUNT;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 5, TimeUnit.SECONDS);
        }

        while (true) {
            if (house.allFoodIsCollected()) {
                executorService.shutdown();
                break;
            }
        }

        house.printAllCollectedFood();
    }
}

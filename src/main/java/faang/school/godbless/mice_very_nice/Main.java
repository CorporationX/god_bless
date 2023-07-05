package faang.school.godbless.mice_very_nice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_THREADS = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(COUNT_THREADS);

        for (int i = 0; i < COUNT_THREADS; i++) {
            executor.schedule(house::collectFood, i * 30, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Food> collectedFood = house.getCollectedFoods();

        for (Food food : collectedFood) {
            System.out.println("Collected food: " + food.getName());
        }
    }
}


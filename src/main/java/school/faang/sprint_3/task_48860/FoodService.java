package school.faang.sprint_3.task_48860;

import java.util.concurrent.ScheduledExecutorService;

public class FoodService implements Runnable {
    private final House house;
    private final ScheduledExecutorService executor;

    public FoodService(House house, ScheduledExecutorService executor) {
        this.house = house;
        this.executor = executor;
    }

    @Override
    public void run() {
        if (house == null) {
            System.out.println("Дом не может быть null");
        }
        house.collectFoods();
        if (house.allFoodCollected()) {
            executor.shutdown();
            System.out.println("Вся еда собрана!");
        }
    }
}

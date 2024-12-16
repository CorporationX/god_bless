package school.faang.task_48273;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = setUpHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Config.SCHEDULED_THREAD_POOL_SIZE);

        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                log.info("All the food in the house is collected: {}", house.getCollectedFoods());
            }
        }, 0, Config.SCHEDULED_THREAD_POOL_FIXED_SECONDS_RATE, TimeUnit.SECONDS);
    }

    private static House setUpHouse() {
        House house = new House();

        Room room1 = new Room("Kitchen");
        Food food1 = new Food("Apple");
        Food food2 = new Food("Steak");
        room1.addFood(food1);
        room1.addFood(food2);
        house.addRoom(room1);

        Room room2 = new Room("Bedroom");
        Food food3 = new Food("Milk");
        Food food4 = new Food("Salad");
        room2.addFood(food3);
        room2.addFood(food4);
        house.addRoom(room2);

        Room room3 = new Room("Living");
        Food food5 = new Food("Cucumber");
        Food food6 = new Food("Rice");
        room3.addFood(food5);
        room3.addFood(food6);
        house.addRoom(room3);

        Room room4 = new Room("Dining");
        Food food7 = new Food("Pizza");
        room4.addFood(food7);
        house.addRoom(room4);

        return house;
    }
}

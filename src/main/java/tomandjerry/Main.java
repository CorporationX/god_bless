package tomandjerry;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int THREAD_POOL_PERIOD = 30;

    public static void main(String[] args) {
        House house = getFilledHouse();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            scheduledExecutorService.scheduleAtFixedRate(house::collectFood, 0,
                    THREAD_POOL_PERIOD, TimeUnit.SECONDS);
        }

        while (true) {
            if (house.allFoodCollected()) {
                System.out.println("Еда в доме собрана!");
                scheduledExecutorService.shutdown();
                break;
            }
        }
        System.out.println(house);
    }

    private static House getFilledHouse() {
        Food food1 = new Food("food1");
        Food food2 = new Food("food2");
        Food food3 = new Food("food3");
        Food food4 = new Food("food4");
        Food food5 = new Food("food5");
        Food food6 = new Food("food6");

        Room room1 = new Room();
        room1.addFood(food1);
        room1.addFood(food2);
        Room room2 = new Room();
        room2.addFood(food3);
        room2.addFood(food4);
        Room room3 = new Room();
        room3.addFood(food5);
        room3.addFood(food6);

        House house = new House();
        house.addRoom(room1);
        house.addRoom(room2);
        house.addRoom(room3);
        return house;
    }
}

package school.faang.sprint_3.task_48477;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int DELAY = 0;
    private static final int PERIOD = 30;

    public static void main(String[] args) {

        List<Food> foods1 = List.of(
                new Food("bacon"),
                new Food("cookies"),
                new Food("pelmeni"),
                new Food("borsch")
        );
        Room kitchen = new Room("Kitchen");
        kitchen.addFood(foods1);

        List<Food> foods2 = List.of(
                new Food("bacon"),
                new Food("chips"),
                new Food("snacks")
        );
        Room livingRoom = new Room("Living room");
        livingRoom.addFood(foods2);

        List<Food> foods3 = List.of(
                new Food("snacks"),
                new Food("cookies"),
                new Food("nuts")
        );
        Room bedroom = new Room("Bedroom");
        bedroom.addFood(foods3);


        List<Food> foods4 = List.of(
                new Food("nuts"),
                new Food("cookies")
        );
        Room bathroom = new Room("Bathroom");
        bathroom.addFood(foods4);

        House house = new House("Tom House");

        house.addRoom(kitchen);
        house.addRoom(livingRoom);
        house.addRoom(bedroom);
        house.addRoom(bathroom);

        CountDownLatch count = new CountDownLatch(house.sizeHouse());
        house.setCount(count);

        try {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
            for (int i = 0; i < THREAD_POOL_SIZE; i++) {
                executor.scheduleAtFixedRate(house::collectFood, DELAY, PERIOD, TimeUnit.SECONDS);
            }

            count.await();
            executor.shutdown();
            System.out.println("All the food in the house is collected!");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

package Multithreading.bc2446;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    final static int COUNT_OF_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        Room bedroom = new Room();
        bedroom.addFood(new Food("Cheese"));
        bedroom.addFood(new Food("Milk"));
        bedroom.addFood(new Food("Meat"));

        Room hall = new Room();
        hall.addFood(new Food("Apple"));
        hall.addFood(new Food("Bread"));
        hall.addFood(new Food("Chocolate"));

        house.addRoom(bedroom);
        house.addRoom(hall);


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(COUNT_OF_THREADS);
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            executorService.schedule(house::collectFood, i * 2, TimeUnit.SECONDS);
        }
        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All foods has been collected");
        }
    }
}

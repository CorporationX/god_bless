package faang.school.godbless.tom_ang_jerry;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HouseFoodCleaner {

    public static void main(String[] args) {
        House house = new House();
        Room bathroom = new Room("Bathroom");
        Room kitchen = new Room("Kitchen");
        Room bedroom = new Room("Bedroom");

        bathroom.addFood(new Food("Fish"));
        kitchen.addFood(new Food("Meat"));
        kitchen.addFood(new Food("Milk"));
        kitchen.addFood(new Food("Cake"));
        kitchen.addFood(new Food("Bread"));
        bedroom.addFood(new Food("Cheese"));
        bedroom.addFood(new Food("Candy"));
        bedroom.addFood(new Food("Chocolate"));

        house.addRoom(bedroom);
        house.addRoom(bathroom);
        house.addRoom(kitchen);

        int totalThreads = 5;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(totalThreads);

        for (int i = 0; i < totalThreads; i++) {
            executor.schedule(house::collectFood, i * 30, TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The food was collected");

        List<Food> collectedFood = house.getCollectedFood();
        System.out.println("Collected food:");
        for (Food food : collectedFood) {
            System.out.println(food.getName());
        }
    }
}

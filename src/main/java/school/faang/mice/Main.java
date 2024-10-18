package school.faang.mice;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log4j2
public class Main {
    private static final int POOL_SIZE = 5;


    public static void main(String[] args) throws InterruptedException {

        List<Food> foodList1 = new ArrayList<>(List.of(
                new Food("Bread"),
                new Food("Mayonnaise"),
                new Food("Eggs"),
                new Food("Avocado")));

        List<Food> foodList2 = new ArrayList<>(List.of(
                new Food("Pork"),
                new Food("Beef"),
                new Food("Chicken"),
                new Food("Mutton")));

        List<Food> foodList3 = new ArrayList<>(List.of(
                new Food("Apples"),
                new Food("Orange"),
                new Food("Bananas"),
                new Food("Cherry")));

        List<Food> foodList4 = new ArrayList<>(List.of(
                new Food("Spread"),
                new Food("Chocolate"),
                new Food("Coffee"),
                new Food("Cacao")));

        List<Food> foodList5 = new ArrayList<>(List.of(
                new Food("Beans"),
                new Food("Lemon"),
                new Food("Creme"),
                new Food("Vino")));

        House house = new House();
        house.roomsList.add(new Room(foodList1));
        house.roomsList.add(new Room(foodList2));
        house.roomsList.add(new Room(foodList3));
        house.roomsList.add(new Room(foodList4));
        house.roomsList.add(new Room(foodList5));

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            scheduler.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }
        while (!house.roomsList.stream().allMatch(room -> room.foodList().isEmpty())) {
            Thread.sleep(1000);
        }

        scheduler.shutdown();
        try {
            if (scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Foods collected");
            } else {
                System.out.println("Waiting time expired.  Forcing shutdown.");
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread" + Thread.currentThread().getName() + "was interrupted", e);
            throw new IllegalStateException("Thread" + Thread.currentThread().getName() + "was interrupted", e);
        }
    }
}

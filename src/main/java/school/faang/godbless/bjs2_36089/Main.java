package school.faang.godbless.bjs2_36089;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int TIME_INTERVAL = 30;

    public static void main(String[] args) {
        Room room1 = new Room(List.of(new Food("Banana"), new Food("Steak"), new Food("Onion")));
        Room room2 = new Room(List.of(new Food("Egg"), new Food("Butter")));
        Room room3 = new Room(List.of(new Food("Cheese"), new Food("Garlic"), new Food("Bacon")));
        House house = new House(List.of(room1, room2, room3));

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
        pool.scheduleAtFixedRate(house::collectFood, 0, TIME_INTERVAL, TimeUnit.SECONDS);
        while (!house.allFoodCollected()) {
        }
        pool.shutdown();
        try {
            if (!pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                throw new IllegalStateException("Not terminated");
            }
            System.out.println("Food collected");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted when waiting for termination");
        }
    }
}

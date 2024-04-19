package faang.school.godbless.MiceAreNice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TERMINATION_INTERVAL = 30;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        House house = new House(getRooms(), new ArrayList<>());
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(THREADS_COUNT);
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            pool.schedule(() -> house.collectFood(finalI), TERMINATION_INTERVAL, TimeUnit.SECONDS);
        }

        pool.shutdown();

        try {
            while (!pool.awaitTermination(TERMINATION_INTERVAL, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Room> getRooms() {
        List<Food> food1 = new ArrayList<>();
        food1.add(new Food("Rice"));
        food1.add(new Food("Potato"));

        List<Food> food2 = new ArrayList<>();
        food1.add(new Food("Cheese"));
        food1.add(new Food("Bread"));

        List<Food> food3 = new ArrayList<>();
        food1.add(new Food("Berries"));
        food1.add(new Food("Broccoli"));

        List<Food> food4 = new ArrayList<>();
        food1.add(new Food("Chips"));
        food1.add(new Food("Waffles"));

        return List.of(new Room(food1), new Room(food2), new Room(food3), new Room(food4));
    }
}

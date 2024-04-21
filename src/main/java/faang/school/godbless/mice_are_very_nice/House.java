package faang.school.godbless.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        int delay = 5000;
        List<Room> rooms = initialize();
        List<Food> foods = new ArrayList<>();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.schedule(() ->
                    collectFood(rooms, foods),
                    delay,
                    TimeUnit.MILLISECONDS
            );
            delay += 5000;
        }

        try {
            executorService.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        executorService.shutdown();
        System.out.println("Food collected");
        System.out.println(foods);
    }

    public static synchronized void collectFood(List<Room> rooms, List<Food> foods) {
        System.out.println(Thread.currentThread().getName() + " working.");
        int counter = 0;
        for (int i = 0; i < rooms.size() || counter == 2; i++) {
            if (!rooms.get(i).getFoods().isEmpty()) {
                counter++;
                foods.addAll(rooms.get(i).getFoods());
                rooms.get(i).setFoods(new ArrayList<>());
            }
        }
    }

    public static List<Room> initialize() {
        return List.of(
                new Room(List.of(new Food("meat"), new Food("milk"), new Food("bread"), new Food("potato"))),
                new Room(List.of(new Food("cucumber"), new Food("milk"), new Food("bread"), new Food("meat"))),
                new Room(List.of(new Food("milk"), new Food("fish"), new Food("bread"), new Food("potato"))),
                new Room(List.of(new Food("tomato"), new Food("milk"), new Food("fish"), new Food("potato")))
        );
    }
}
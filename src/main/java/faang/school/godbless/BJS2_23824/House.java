package faang.school.godbless.BJS2_23824;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> foods = new ArrayList<>();
    private static final int ROOM_COUNT = 20;
    private static final int THREAD_COUNT = 5;
    private static final int THREAD_DELAY_SECONDS = 30;

    public static void main(String[] args) {
        initialize();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_COUNT);

        for (int i = 0; i < ROOM_COUNT; i += 2) {
            int roomIndex = i;
            scheduledExecutorService.schedule(() -> collectFood(roomIndex), THREAD_DELAY_SECONDS, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();

        try {
            if (scheduledExecutorService.awaitTermination(10, TimeUnit.MINUTES)) {
                System.out.println("All foods collected: " + foods);
            } else {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
        }

    }

    private static void collectFood(int roomIndex) {
        Room room = rooms.get(roomIndex);
        Room room2 = rooms.get(roomIndex + 1);

        System.out.println("Collecting food of " + room.getName());
        System.out.println("Collecting food of " + room2.getName());

        foods.addAll(room.getFoods());
        foods.addAll(room2.getFoods());

        room.getFoods().clear();
        room2.getFoods().clear();
    }


    private static void initialize() {
        List<Food> foodList = List.of(new Food("cheese"), new Food("milk"), new Food("meat"), new Food("bread"), new Food("cereal"));
        for (int i = 0; i < ROOM_COUNT; i++) {
            Room room = new Room("room " + i);
            room.setFoods(foodList);
            rooms.add(room);
        }
    }
}

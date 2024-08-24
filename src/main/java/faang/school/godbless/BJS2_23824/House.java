package faang.school.godbless.BJS2_23824;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> foods = new ArrayList<>();
    private static final int ROOM_COUNT = 10;
    private static final int THREAD_COUNT = 5;
    private static final int THREAD_DELAY_SECONDS = 30;
    private static final int ROOM_COUNT_TO_PROCESS = 2;

    public static void main(String[] args) {
        initialize();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(THREAD_COUNT);

        int delay = THREAD_DELAY_SECONDS;

        for (int i = 0; i < ROOM_COUNT; i += ROOM_COUNT_TO_PROCESS) {
            int roomIndex1 = i;
            int roomIndex2 = i + 1;

            scheduledExecutorService.schedule(() -> collectFood(roomIndex1, roomIndex2), delay, TimeUnit.SECONDS);
            delay += THREAD_DELAY_SECONDS;
        }

        scheduledExecutorService.shutdown();

        try {
            if (scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All foods collected: " + foods);
            } else {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
        }

    }

    private static void collectFood(int roomIndex1, int roomIndex2) {

        Room room1 = rooms.get(roomIndex1);
        Room room2 = rooms.get(roomIndex2);

        System.out.println("Collecting food of " + room1.getName());
        System.out.println("Collecting food of " + room2.getName());

        foods.addAll(room1.getFoods());
        foods.addAll(room2.getFoods());

        room1.getFoods().clear();
        room2.getFoods().clear();
    }

    private static void initialize() {

        List<Food> foodList = new ArrayList<>();

        foodList.add(new Food("cheese"));
        foodList.add(new Food("milk"));
        foodList.add(new Food("meat"));
        foodList.add(new Food("bread"));
        foodList.add(new Food("cereal"));

        for (int i = 0; i < ROOM_COUNT; i++) {
            Room room = new Room("room " + i);
            room.setFoods(new ArrayList<>(foodList));
            rooms.add(room);
        }
    }
}

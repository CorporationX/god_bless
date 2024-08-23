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
            scheduledExecutorService.schedule(() -> collectFood(getRoomsWithFood()), delay, TimeUnit.SECONDS);
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

    private static void collectFood(List<Room> roomsToCollect) {

        roomsToCollect.forEach(room -> {
            System.out.println("Collecting food of " + room.getName());
            foods.addAll(room.getFoods());
            room.getFoods().clear();
        });

    }

    private static List<Room> getRoomsWithFood() {
        return rooms.stream()
                .filter(room -> !room.getFoods().isEmpty())
                .limit(ROOM_COUNT_TO_PROCESS)
                .toList();
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

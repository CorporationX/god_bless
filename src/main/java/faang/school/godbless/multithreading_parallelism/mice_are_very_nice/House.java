package faang.school.godbless.multithreading_parallelism.mice_are_very_nice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class House {

    private static final int POOL_SIZE = 5;
    private static final int DELAY = 1;
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Food> collectedFood = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Room room1 = new Room("room_1", Stream.of(new Food("food_1"), new Food("food_2"), new Food("food_3")).collect(Collectors.toList()));
        Room room2 = new Room("room_2", Stream.of(new Food("food_3"), new Food("food_4"), new Food("food_5")).collect(Collectors.toList()));
        Room room3 = new Room("room_3", Stream.of(new Food("food_6"), new Food("food_7"), new Food("food_8")).collect(Collectors.toList()));
        Room room4 = new Room("room_4", Stream.of(new Food("food_9"), new Food("food_10"), new Food("food_11")).collect(Collectors.toList()));
        Room room5 = new Room("room_5", Stream.of(new Food("food_12"), new Food("food_13"), new Food("food_14")).collect(Collectors.toList()));
        Room room6 = new Room("room_6", Stream.of(new Food("food_15"), new Food("food_16"), new Food("food_17")).collect(Collectors.toList()));
        Room room7 = new Room("room_7", Stream.of(new Food("food_18"), new Food("food_19"), new Food("food_20")).collect(Collectors.toList()));
        Room room8 = new Room("room_8", Stream.of(new Food("food_21"), new Food("food_22"), new Food("food_23")).collect(Collectors.toList()));
        Room room9 = new Room("room_9", Stream.of(new Food("food_24"), new Food("food_25"), new Food("food_26")).collect(Collectors.toList()));
        Room room10 = new Room("room_10", Stream.of(new Food("food_27"), new Food("food_28"), new Food("food_29")).collect(Collectors.toList()));

        Collections.addAll(rooms, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            scheduledExecutorService.schedule(() -> {
                try {
                    collectFood();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, DELAY, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();
        scheduledExecutorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("Готово!");
    }

    private synchronized static void collectFood() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            if (!rooms.isEmpty()) {
                Room room = rooms.remove(0);
                collectedFood.addAll(room.getFoods());
                room.getFoods().clear();
            }
        }
    }
}

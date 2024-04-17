package faang.school.godbless.multithreading.task_8;

import faang.school.godbless.multithreading.task_8.model.Food;
import faang.school.godbless.multithreading.task_8.model.House;
import faang.school.godbless.multithreading.task_8.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 5;
    private static final int INTERVAL = 30;

    public static void main(String[] args) {
        House house = new House(getRooms(), new ArrayList<>());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        for (int index = 0; index < 2; index++) {
            final int currentIndex = index;
            executor.schedule(() -> house.collectFood(currentIndex), INTERVAL, TimeUnit.SECONDS);
        }
        executor.shutdown();
    }

    private static List<Room> getRooms() {
        List<Food> foodFromLivingRoom = Arrays.asList(new Food("сыр"),
                new Food("хлеб"), new Food("ветчина"));
        List<Food> foodFromBedroom = Arrays.asList(new Food("рис"), new Food("укроп"));
        Room livingRoom = new Room("гостиная", foodFromLivingRoom);
        Room bedroom = new Room("спальня", foodFromBedroom);
        return List.of(livingRoom, bedroom);
    }
}

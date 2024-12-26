package school.faang.sprint_1.task_miceareverynicebjs2n48375;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MiceMain {

    public static void main(String[] args) {
        int roomsNumber = 5;
        int numberOfThreads = 5;

        List<List<Food>> foodInRooms = new ArrayList<>();
        for (int i = 0; i < roomsNumber; i++) {
            foodInRooms.add(
                    new ArrayList<>(List.of(
                            new Food("Хлеб"),
                            new Food("Яблоки")
                    ))
            );
        }

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomsNumber; i++) {
            rooms.add(new Room(foodInRooms.get(i)));
        }

        ScheduledExecutorService executorScheduled = Executors.newScheduledThreadPool(numberOfThreads);
        House house = new House(rooms, new ArrayList<>(), executorScheduled);
        log.info("Initial state of rooms {} :", house.getRooms());
        executorScheduled.scheduleAtFixedRate(house, 1, 3, TimeUnit.SECONDS);
    }
}

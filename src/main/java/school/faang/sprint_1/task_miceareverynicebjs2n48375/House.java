package school.faang.sprint_1.task_miceareverynicebjs2n48375;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
public class House implements Runnable{
    @NonNull
    private List<Room> rooms;
    private List<Food> food;

    @Override
    public void run() {
        collectFood();
    }

    public void collectFood() {
        int roomNumber1 = randomRoomIndex();
        int roomNumber2 = randomRoomIndex();

        food.addAll(rooms.get(roomNumber1).getFood());
        rooms.get(roomNumber1).removeFood();

        food.addAll(rooms.get(roomNumber2).getFood());
        rooms.get(roomNumber2).removeFood();
        System.out.printf("%s - room %s and %s are visited by mice\n", Thread.currentThread().getName(), roomNumber1, roomNumber2);
    }

    private int randomRoomIndex() {
        return (int)((Math.random() * rooms.size()));
    }

    public static void main(String[] args) {
        int numberOfThreads = 5;

        List<Food> foods = new ArrayList<>(List.of(
                new Food("Каша гречневая"),
                new Food("Каша пшеничная"),
                new Food("Молоко"),
                new Food("Хлеб"),
                new Food("Персики"),
                new Food("Яблоки")
                ));
        List<Room> rooms = new ArrayList<>(List.of(
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods),
                new Room(foods)
                ));

        House house = new House(rooms, new ArrayList<>());

        ScheduledExecutorService executorScheduled = Executors.newScheduledThreadPool(numberOfThreads);
        executorScheduled.scheduleAtFixedRate(house, 1, 1, TimeUnit.SECONDS);
    }
}

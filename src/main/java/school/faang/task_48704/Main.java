package school.faang.task_48704;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        Food cheese = new Food("Сыр", 5);
        Food bread = new Food("Хлеб", 2);
        Food meat = new Food("Мясо", 4);

        List<Food> foodsRoom1 = new ArrayList<>();
        foodsRoom1.add(meat);

        List<Food> foodsRoom2 = new ArrayList<>();
        foodsRoom2.add(bread);

        List<Food> foodsRoom3 = new ArrayList<>();
        foodsRoom3.add(cheese);

        Room room1 = new Room("Спальня", foodsRoom1);
        Room room2 = new Room("Кухня", foodsRoom2);
        Room room3 = new Room("Холл", foodsRoom3);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        House house = new House(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        executor.scheduleAtFixedRate(() -> {
            if (house.collectFood()) {
                executor.shutdown();
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
}

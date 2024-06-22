package faang.school.godbless.multithreading.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        House house = new House();

        house.addRoom(new Room(
                "Кухня",
                new ArrayList<>(List.of(
                        new Food("Молоко", 1),
                        new Food("Мясо", 2),
                        new Food("Хлеб", 3),
                        new Food("Печенье", 7),
                        new Food("Яблоко", 3)
                ))
        ));
        house.addRoom(new Room(
                "Гостиная",
                new ArrayList<>(List.of(
                        new Food("Молоко", 3),
                        new Food("Мясо", 1),
                        new Food("Хлеб", 1),
                        new Food("Печенье", 3),
                        new Food("Яблоко", 6),
                        new Food("Аппельсин", 3)
                ))
        ));
        house.addRoom(new Room(
                "Спальня",
                new ArrayList<>(List.of(
                        new Food("Лимонад", 2),
                        new Food("Мясо", 0),
                        new Food("Хлеб", 1),
                        new Food("Печенье", 4),
                        new Food("Чипсы", 2)
                ))
        ));

        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            scheduleExecutorService.schedule(house::collectFood, 3 * (i + 1), TimeUnit.SECONDS);
        }

        scheduleExecutorService.shutdown();
        while (!scheduleExecutorService.isTerminated()) {}
        System.out.println("Вся еда собрана");
    }
}

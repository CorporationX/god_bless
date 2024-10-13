package school.faang.miceareverynice.main;

import school.faang.miceareverynice.maincode.Food;
import school.faang.miceareverynice.maincode.House;
import school.faang.miceareverynice.maincode.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        House house = new House();

        house.addRoom(new Room(new ArrayList<>(Arrays.asList(new Food("Яблоко"), new Food("Банан")))));
        house.addRoom(new Room(new ArrayList<>(Arrays.asList(new Food("Хлеб"), new Food("Молоко")))));
        house.addRoom(new Room(new ArrayList<>(Arrays.asList(new Food("Сыр"), new Food("Колбаса")))));
        house.addRoom(new Room(new ArrayList<>(Arrays.asList(new Food("Вода"), new Food("Сок")))));
        house.addRoom(new Room(new ArrayList<>(Arrays.asList(new Food("Каша"), new Food("Мясо")))));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        executor.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);

        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Еда в доме собрана");
        }, 2 , TimeUnit.MINUTES);
    }
}

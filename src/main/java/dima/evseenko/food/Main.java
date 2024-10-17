package dima.evseenko.food;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 5;
    private static final int PERIOD = 30;

    public static void main(String[] args) {
        House house = new House();
        house.getRooms().addAll(getRooms());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREADS_COUNT);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, PERIOD, TimeUnit.SECONDS);
        }

        executorService.shutdown();

        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("Еда в доме собрана!");
                break;
            }
        }
    }

    private static List<Room> getRooms() {
        Room room1 = new Room();
        room1.getFoods().addAll(List.of(
                new Food("Сыр"),
                new Food("Колбаса"),
                new Food("Майонез"),
                new Food("Хлеб")
        ));

        Room room2 = new Room();
        room2.getFoods().addAll(List.of(
                new Food("Чай"),
                new Food("Лосось"),
                new Food("Творог"),
                new Food("Арбуз")
        ));

        Room room3 = new Room();
        room3.getFoods().addAll(List.of(
                new Food("Шаурма"),
                new Food("Молоко"),
                new Food("Лук"),
                new Food("Чеснок")
        ));

        Room room4 = new Room();
        room4.getFoods().addAll(List.of(
                new Food("Торт"),
                new Food("Шоколад"),
                new Food("Кофе"),
                new Food("Тунец")
        ));

        return List.of(room1, room2, room3);
    }
}

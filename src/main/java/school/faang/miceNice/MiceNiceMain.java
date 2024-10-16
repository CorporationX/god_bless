package school.faang.miceNice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MiceNiceMain {
    public static void main(String[] args) {
        House house = new House();

        house.addRoom(new Room("Кухня", List.of(new Food("Яблоко"), new Food("Банан"))));
        house.addRoom(new Room("Гостиная", List.of(new Food("Печенье"), new Food("Молоко"))));
        house.addRoom(new Room("Спальня", List.of(new Food("Шоколад"), new Food("Сок"))));
        house.addRoom(new Room("Ванная", List.of(new Food("Вода"), new Food("Фрукты"))));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();

            System.out.println("Еда в доме собрана!");
            System.out.printf("Собранная еда: %s\n", house.getCollectedFood());
        }, 2, TimeUnit.SECONDS);
    }
}

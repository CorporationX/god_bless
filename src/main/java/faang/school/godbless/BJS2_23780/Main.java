package faang.school.godbless.BJS2_23780;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = List.of(
                new Room("Кухня", List.of(new Food("Яблоко"), new Food("Банан"))),
                new Room("Гостиная", List.of(new Food("Пицца"), new Food("Сок"))),
                new Room("Спальня", List.of(new Food("Шоколад"), new Food("Молоко"))),
                new Room("Ванная", List.of(new Food("Печенье"), new Food("Кофе"))),
                new Room("Коридор", List.of(new Food("Чай"), new Food("Орехи"))),
                new Room("Балкон", List.of(new Food("Мороженое"), new Food("Йогурт")))
        );

        House house = new House();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < rooms.size(); i += 2) {
            List<Room> assignedRooms = rooms.subList(i, Math.min(i + 2, rooms.size()));
            int delay = (i / 2) * 30;
            executor.schedule(() -> house.collectFood(assignedRooms), delay, TimeUnit.SECONDS);
        }

        executor.schedule(() -> {
            if (house.allFoodCollected(rooms)) {
                System.out.println("Еда в доме собрана!");
            } else {
                System.out.println("Не вся еда была собрана!");
            }
            executor.shutdown();
        }, 30L * (rooms.size() / 2 + 1) + 5, TimeUnit.SECONDS);
    }
}

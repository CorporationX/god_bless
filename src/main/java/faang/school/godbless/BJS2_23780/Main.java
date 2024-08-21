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

        House house = new House(rooms);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < rooms.size(); i += 2) {
            final int index = i;
            executor.schedule(() -> {
                System.out.println("Поток " + Thread.currentThread().getName() + " начинает сборку еды из комнат: "
                        + rooms.get(index).getName() + " и " + rooms.get(index + 1).getName());
                house.collectFood(index);
            }, 30L * (i / 2), TimeUnit.SECONDS);
        }
        executor.schedule(() -> {
            if (house.allFoodCollected()) {
                System.out.println("Еда в доме собрана!");
            } else {
                System.out.println("Не вся еда была собрана!");
            }
            executor.shutdown();
        }, 30L * (rooms.size() / 2 + 1) + 5, TimeUnit.SECONDS);

        executor.schedule(() -> {
            if (!executor.isShutdown()) {
                System.out.println("Что-то пошло не так! Закрытие пула потоков.");
                executor.shutdown();
            }
        }, 200, TimeUnit.SECONDS);
    }
}

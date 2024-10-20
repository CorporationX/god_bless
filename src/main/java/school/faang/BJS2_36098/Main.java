package school.faang.BJS2_36098;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        Room room1 = new Room(new ArrayList<>(List.of(new Food("Яблоко"), new Food("Груша"))));
        Room room2 = new Room(new ArrayList<>(List.of(new Food("Морковь"), new Food("Помидор"))));
        Room room3 = new Room(new ArrayList<>(List.of(new Food("Сыр"), new Food("Колбаса"))));
        Room room4 = new Room(new ArrayList<>(List.of(new Food("Молоко"), new Food("Хлеб"))));

        House house = new House(List.of(room1, room2, room3, room4));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        executor.scheduleAtFixedRate(() -> {
            try {
                house.collectFood();

                if (house.allFoodCollected()) {
                    System.out.println("Еда в доме собрана!");
                    executor.shutdown();
                }
            } catch (Exception e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 30, TimeUnit.SECONDS);

        executor.schedule(() -> {
            if (!executor.isShutdown()) {
                executor.shutdown();
                System.out.println("Принудительное завершение работы через 2 минуты.");
            }

            System.out.println("Список собранной еды:");
            house.getCollectedFood().forEach(food -> System.out.println(food.getName()));
        }, 2, TimeUnit.MINUTES);
    }
}
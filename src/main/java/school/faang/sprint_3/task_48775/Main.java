package school.faang.sprint_3.task_48775;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int NUMBER_OF_ROOMS = 3;
    private static final int FOOD_PER_ROOM = 2;

    public static void main(String[] args) {
        House house = new House();

        IntStream.range(1, NUMBER_OF_ROOMS + 1).forEach(i -> {
            Room room = new Room();
            IntStream.range(1, FOOD_PER_ROOM + 1).forEach(j ->
                    room.addFood(new Food("Еда из комнаты " + i + "-" + j))
            );
            house.addRoom(room);
        });

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        scheduler.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.allFoodCollected()) {
                scheduler.shutdown();
                System.out.println("Еда в доме собрана!");
                System.out.println("Собранная еда: " + house.getCollectedFood());
            }
        }, 0, COLLECTION_INTERVAL_SECONDS, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
                System.out.println("Принудительное завершение работы.");
                System.out.println("Собранная еда: " + house.getCollectedFood());
            }
        }, 2, TimeUnit.MINUTES);
    }
}

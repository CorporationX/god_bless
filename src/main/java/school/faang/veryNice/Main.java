package school.faang.veryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < 5; i++) {
            Room room = new Room();
            room.addFood(new Food("Еда " + (i + 1)));
            house.addRoom(room);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        Runnable task = () -> {
            house.collectFood();
        };

        executorService.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            executorService.shutdown();
            house.showCollectedFood();
            System.out.println("Еда в доме собрана!");
        }, 2, TimeUnit.MINUTES);
    }
}

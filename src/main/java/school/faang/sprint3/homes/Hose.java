package school.faang.sprint3.homes;

import java.util.concurrent.*;

public class Hose {
    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 5; i++) {
            Room room = new Room();
            room.addFood(new Food("Еда из комнаты " + i));
            room.addFood(new Food("Еда 2 из комнаты " + i));
            house.addRoom(room);
        }
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(() -> {
                house.collectFood();
            }, 0, 30, TimeUnit.SECONDS);
        }
        executorService.schedule(() -> {
            executorService.shutdown();
            System.out.println("Еда в доме собран!");
            house.showCollectedFood();
        }, 90, TimeUnit.SECONDS);
    }
}

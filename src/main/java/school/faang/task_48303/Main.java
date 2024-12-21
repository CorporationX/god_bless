package school.faang.task_48303;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < 10; i++) {
            Room room = new Room(i);
            for (int j = 0; j < 5; j++) {
                room.addFood(new Food("Еда " + j));
            }
            house.addRoom(room);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(() -> {
            if (house.collectFood()) {
                executorService.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Собранная еда: " + house.getCollectedFood().size());
        } else {
            executorService.shutdownNow();
        }
    }
}
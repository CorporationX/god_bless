package faang.school.godbless.module.third.parallelism.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class House {
    public static void main(String[] args) {
        List<Room> rooms = createRooms(6);
        int poolSize = 5;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(poolSize);
        List<Food> collectedFood = new ArrayList<>();
        final int DELAY_SECONDS = 3;
        for (int i = 0; i < poolSize; i++) {
            scheduledExecutorService.schedule(
                () -> collectedFood.addAll(collectFood(rooms)),
                DELAY_SECONDS,
                TimeUnit.SECONDS
            );
        }
        scheduledExecutorService.shutdown();
        try {
            scheduledExecutorService.awaitTermination(10 * DELAY_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Вся еда собрана. Её количество %d", collectedFood.size());
    }
    
    private static List<Room> createRooms(int numberOfRooms) {
        return IntStream.range(0, new Random().nextInt(numberOfRooms)).mapToObj((index) -> new Room()).toList();
    }
    
    private static List<Food> collectFood(List<Room> rooms) {
        return rooms.stream().limit(2).flatMap(room -> room.gatherFood().stream()).toList();
    }
}

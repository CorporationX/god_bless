package school.faang.bjs248710;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    private static final List<String> FOODS = List.of(
            "meat",
            "cheese",
            "milk",
            "meat",
            "vegetables",
            "cat food",
            "fruits"
    );
    private static final int MAX_FOODS = 10;
    private static final int MAX_ROOMS = 10;
    private static final int POOL_SIZE = 5;
    private static final int PERIOD = 30;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final Consumer<ScheduledExecutorService> CALLBACK = (executorService) -> {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(PERIOD, TIME_UNIT)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("Еда в доме собрана!");
    };


    public static void main(String[] args) {
        House house = new House(generateRooms(), CALLBACK);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(POOL_SIZE);
        executorService.scheduleAtFixedRate(() -> house.collectFood(executorService), 0, PERIOD, TIME_UNIT);
    }

    private static List<Food> generateFoods() {
        return new Random().ints(getRandomInt(MAX_FOODS), 0, FOODS.size())
                .mapToObj(i -> new Food(FOODS.get(i)))
                .toList();
    }

    private static List<Room> generateRooms() {
        return Stream.iterate(0, n -> n + 1)
                .limit(getRandomInt(MAX_ROOMS))
                .map(i -> new Room(generateFoods()))
                .toList();
    }

    private static int getRandomInt(Integer max) {
        return new Random().nextInt(max);
    }
}

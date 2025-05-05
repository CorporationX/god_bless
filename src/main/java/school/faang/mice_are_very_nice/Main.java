package school.faang.mice_are_very_nice;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_NUMBER = 5;
    private static final int SHUTDOWN_TIMEOUT_SECONDS = 1;
    private static final int FOOD_COLLECTION_INTERVAL_SECONDS = 30;
    private static volatile boolean isCollectionFinished = false;

    public static void main(String[] args) {
        House house = generateTestData();
        HouseService houseService = new HouseService(house);

        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(THREAD_NUMBER);

        scheduledPool.scheduleAtFixedRate(() -> {
            houseService.collectFood();

            if (!isCollectionFinished && houseService.isAllFoodCollected()) {
                isCollectionFinished = true;
                System.out.println("All food collected!");
                shutdownExecutorService(scheduledPool);
            }
        }, 0, FOOD_COLLECTION_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    private static void shutdownExecutorService(ScheduledExecutorService scheduledPool) {
        scheduledPool.shutdown();

        try {
            if (!scheduledPool.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.MINUTES)) {
                scheduledPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static House generateTestData() {
        return new House("Дом", List.of(
                new Room(List.of(
                        new Food("Яблоко"),
                        new Food("Хлеб"),
                        new Food("Масло")
                )),
                new Room(List.of(
                        new Food("Сыр"),
                        new Food("Молоко"),
                        new Food("Йогурт")
                )),
                new Room(List.of(
                        new Food("Курица"),
                        new Food("Говядина"),
                        new Food("Рыба")
                )),
                new Room(List.of(
                        new Food("Макароны"),
                        new Food("Рис")
                )),
                new Room(List.of(
                        new Food("Помидор"),
                        new Food("Огурец"),
                        new Food("Морковь"),
                        new Food("Картофель")
                )),
                new Room(List.of(
                        new Food("Лук"),
                        new Food("Чеснок")
                )),
                new Room(List.of())
        ));
    }
}
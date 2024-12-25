package school.faang.task_48576;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class House {

    private static final int THREAD_POOL_SIZE = 5;
    private static final List<Food> COLLECTED_FOOD_LIST = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        FoodCollector.initializeRooms();

        ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        for (int i = 1; i < THREAD_POOL_SIZE; i++) {
            executorService.execute(FoodCollector::collectFood);
            Thread.sleep(3000);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.info("Принудительное завершение при прерывании" + e.getMessage());

        }

        System.out.println("Еда в доме собрана");

    }

}

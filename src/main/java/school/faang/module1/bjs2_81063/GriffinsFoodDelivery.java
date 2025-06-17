package school.faang.module1.bjs2_81063;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {

    private static final int THREAD_POOL_SIZE = 3;
    private static final int FOOD_AMOUNT_MIN = 10;
    private static final int FOOD_AMOUNT_MAX = 100;
    private static final int AWAIT_TERMINATION_TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String characterName : characterNames) {
            int foodAmount = ThreadLocalRandom.current().nextInt(FOOD_AMOUNT_MIN, FOOD_AMOUNT_MAX + 1);
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(characterName, foodAmount);
            executorService.execute(foodDeliveryTask);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ожидание завершения было прервано", e);
            executorService.shutdownNow();
        }
    }
}
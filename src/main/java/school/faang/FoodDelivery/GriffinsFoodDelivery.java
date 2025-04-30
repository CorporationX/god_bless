package school.faang.FoodDelivery;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREADS_AMOUNT = 3;
    private static final int MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_AMOUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String characterName : characterNames) {
            int foodAmount = random.nextInt(500) + 1;
            FoodDeliveryTask foodDelivery = new FoodDeliveryTask(characterName, foodAmount);
            executor.submit(foodDelivery);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                executor.shutdownNow(); // Принудительное завершение, если задачи зависли
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow(); // Принудительное завершение при прерывании
        }
    }
}

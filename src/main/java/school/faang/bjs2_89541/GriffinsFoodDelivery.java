package school.faang.bjs2_89541;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREAD = 3;
    private final static int AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();

        for (int i = 0; i < characterNames.length; i++) {
            FoodDeliveryTask foodDeliveryTask = new FoodDeliveryTask(
                    characterNames[random.nextInt(characterNames.length)],
                    random.nextInt(100));
            executor.execute(foodDeliveryTask);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились вовремя, принудительное закрытие пула потоков.");
                executor.shutdownNow();
            } else {
                log.info("Все доставки выполнены успешно.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}

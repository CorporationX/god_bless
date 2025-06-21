package school.faang.griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "GriffinsFoodDelivery")
public class GriffinsFoodDelivery {
    
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (var characterName : characterNames) {
            executor.execute(new FoodDeliveryTask(characterName, RANDOM.nextInt(50)));
        }
        executor.shutdown();
        var executorName = executor.getClass().getSimpleName();
        log.info("{} | Запрос на завершение работы", executorName);
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("{} | Принудительное завершение работы", executorName);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("{} | Принудительное завершение работы", executorName, e.getCause());
        }
        log.info("{} | Завершение работы", executorName);
    }
}

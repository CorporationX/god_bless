package school.faang.griffin;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.RandomUtils.RANDOM;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "GriffinsFoodDelivery")
public class GriffinsFoodDelivery {

    private static final int THREADS_NUM = 3;
    private static final int MAX_RAND_INT = 50;
    private static final int MAX_EXECUTOR_AWAIT_TERMINATION_TIME = 5;

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(THREADS_NUM);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (var characterName : characterNames) {
            executor.execute(new FoodDeliveryTask(characterName, RANDOM.nextInt(MAX_RAND_INT)));
        }
        executor.shutdown();
        var executorName = executor.getClass().getSimpleName();
        log.info("{} | Запрос на завершение работы", executorName);
        try {
            if (!executor.awaitTermination(MAX_EXECUTOR_AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
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

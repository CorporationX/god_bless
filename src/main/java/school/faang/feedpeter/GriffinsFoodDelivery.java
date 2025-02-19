package school.faang.feedpeter;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {

    private static final int THREAD_COUNT = 3;
    private static final int AWAIT_TERMINATION = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        Random random = new Random();
        Arrays.stream(characterNames)
                .map(character -> new FoodDeliveryTask(character, random.nextInt(1, 50)))
                .forEach(executor::submit);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS)) {
                log.warn("Потоки не завершили работу по истечение {} секунд. " +
                        "Принудительно завершаю работу", AWAIT_TERMINATION);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Выполнение потока прервано в процессе остановки ", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

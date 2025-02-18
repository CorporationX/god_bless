package school.faang.weasley;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeasleyFamily.class);

    public static void main(String[] args) {

        Chore[] chores = {new Chore("Помыть посуду"),
                new Chore("Подмести пол"),
                new Chore("Приготовить ужин")
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(executor::submit);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                LOGGER.warn("Превышен тайм-аут. Принудительное завершение работы...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Поток, прерванный во время завершения работы: {}", e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

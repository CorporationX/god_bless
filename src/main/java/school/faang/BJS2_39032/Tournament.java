package school.faang.BJS2_39032;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class Tournament {
    private static final int THREAD_NUMBERS = 3;
    private static final Logger logger = LoggerFactory.getLogger(Tournament.class);
    ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBERS);

    public Tournament() {}

    public CompletableFuture<School> startTask(School school, Task task) {
        logger.info("Команда {} начала квест {}", school.getName(), task.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
                for (Student student : school.getTeam()) {
                    student.addPoits(task.getReward());
                }
                logger.info("Команда {} завершила квест {}", school.getName(), task.getName());
            } catch (Exception e) {
                logger.error("Ошибка при запуске потока", e);
            }
            return school;
        }, executor);
    }

    public void shutdown(){
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                logger.info("Принудительное завершение потоков");
                executor.shutdownNow();
            }
        } catch (Exception e) {
            logger.error("Ошибка при завершении потоков", e);
            executor.shutdownNow();
        }
    }
}

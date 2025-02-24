package school.faang.BJS2_61182;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Task> tasks = List.of(new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );
        List<? extends Future<?>> futures = tasks.stream()
                .map(executor::submit).toList();

        for (Future<?> future : futures) {
            try {
                future.get();
                System.out.print("Задача выполнена успешно\n");
            } catch (Exception e) {
                System.err.printf("Ошибка при выполнении задачи: %s\n", e.getMessage());
            }
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.print("Timed out waiting for threads to finish\n");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.print("Thread interrupted\n");
            executor.shutdownNow();
        }
    }
}

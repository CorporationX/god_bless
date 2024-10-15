package school.faang.bigbangtheory.main;

import school.faang.bigbangtheory.maincode.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_COUNT = 4;
    public static void main(String[] args) {
        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leonardTask = new Task("Леонард", "моделирование эксперимента");
        Task govardTask = new Task("Говард ", "разработка инструментов");
        Task rajeshTask = new Task("Раджеш", "анализ данных");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(sheldonTask);
        executor.submit(leonardTask);
        executor.submit(govardTask);
        executor.submit(rajeshTask);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

package school.faang.thebigbangtheory;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        Map<String, String> executors = Map.of(
                "Шелдон", "Подготовка теории",
                "Леонард", "Моделирование эксперимента",
                "Говард", "Разработка инструментов",
                "Раджеш", "Анализ данных"
        );
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (var entry : executors.entrySet()) {
            executor.submit(new Task(entry.getKey(), entry.getValue()));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

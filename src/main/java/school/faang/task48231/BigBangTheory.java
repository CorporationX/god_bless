package school.faang.task48231;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        Map<String, String> students = new HashMap<>(Map.of(
                "Шелдон", "подготовка теории",
                "Леонард", "моделирование эксперимента",
                "Говард", "разработка инструментов",
                "Раджеш", "анализ данных"
        ));

        List<Task> tasks = students.entrySet().stream()
                .map(entry -> new Task(entry.getKey(), entry.getValue()))
                .toList();

        tasks.forEach(executorService::execute);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
            System.out.println("Все выполнили свои задачи");
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

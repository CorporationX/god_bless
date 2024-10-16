package dima.evseenko.tbbt;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private final int TREADS_COUNT = 4;

    public void executeTasks() {
        ExecutorService executorService = Executors.newFixedThreadPool(TREADS_COUNT);
        getTaskNames().forEach((name, task) -> executorService.submit(new Task(name, task)));
        executorService.shutdown();
    }

    private Map<String, String> getTaskNames() {
        return Map.of(
                "Шелдон", "подготовка теории",
                "Леонард", "моделирование эксперимента",
                "Говард", "разработка инструментов",
                "Раджеш", "анализ данных"
        );
    }
}

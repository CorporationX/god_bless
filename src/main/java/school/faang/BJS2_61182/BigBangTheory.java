package school.faang.BJS2_61182;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );
        List<Future<?>> futures = tasks.stream()
                .map(executor::submit).collect(Collectors.toList());
        for (Future<?> future : futures) {
            try {
                future.get();
                System.out.print("Задача выполнена успешно\n");
            } catch (Exception e) {
                System.err.printf("Ошибка при выполнении задачи: %s\n", e.getMessage());
            }
        }
        executor.shutdown();
    }
}

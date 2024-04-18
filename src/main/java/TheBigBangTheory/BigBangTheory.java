package TheBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int COUNT_THREADS = 4;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREADS);

        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разборка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        tasks.forEach(task -> service.execute(task));
        service.shutdown();
        service.awaitTermination(6, TimeUnit.SECONDS);
    }
}

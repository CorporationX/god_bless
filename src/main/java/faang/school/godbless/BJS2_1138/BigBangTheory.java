package faang.school.godbless.BJS2_1138;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> gays = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард ", "разработка инструментов"),
                new Task("Раджеш ", "анализ данных")
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Task task : gays) {
            executor.submit(task);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все задачи выполнены");
    }
}

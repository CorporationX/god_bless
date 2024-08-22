package faang.school.godbless.BJS2_24145;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> taskList = List.of(new Task("Шелдон ", "подготовка теории"),
                new Task("Леонард  ", "моделирование эксперимента"),new Task("Говард  ", "разработка инструментов"),
                new Task("Раджеш  ", "анализ данных"));

        ExecutorService executor = Executors.newFixedThreadPool(4);
        taskList.forEach(executor::execute);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5100, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

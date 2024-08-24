package theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leoTask = new Task("Леонард", "моделирование эксперимента");
        Task govardTask = new Task("Говард", "разработка инструментов");
        Task radjeshTask = new Task("Раджеш", "анализ данных");
        List<Task> tasks = List.of(sheldonTask, leoTask, govardTask, radjeshTask);

        for (int i = 0; i < 4; i++) {
            execute.execute(tasks.get(i));
        }
        try {
            if (!execute.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                execute.shutdownNow();
                System.out.println("Программа завершила работу");
            }
        } catch (InterruptedException e) {
            execute.shutdownNow();
        }
    }
}

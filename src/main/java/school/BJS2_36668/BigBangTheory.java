package school.BJS2_36668;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    final static int FIXED_THREADS = 4;

    public static void main(String[] args) {

        Task task_1 = new Task("Шелдон", "подготовка теории");
        Task task_2 = new Task("Леонард", "моделирование эксперимента");
        Task task_3 = new Task("Говард", "разработка инструментов");
        Task task_4 = new Task("Раджеш", "анализ данных");

        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_THREADS);

        executorService.execute(task_1);
        executorService.execute(task_2);
        executorService.execute(task_3);
        executorService.execute(task_4);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("потоки не завершили свою работу");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

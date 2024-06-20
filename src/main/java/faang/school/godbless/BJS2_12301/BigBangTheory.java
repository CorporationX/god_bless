package faang.school.godbless.BJS2_12301;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task_1 = new Task("Шелдон", "подготовка теории");
        Task task_2 = new Task("Леонард", "моделирование эксперимента");
        Task task_3 = new Task("Говард", "разработка инструментов");
        Task task_4 = new Task("Раджеш", "анализ данных");

        executorService.submit(task_1);
        executorService.submit(task_2);
        executorService.submit(task_3);
        executorService.submit(task_4);

        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) System.out.println("Все задачи выполнены");
    }
}

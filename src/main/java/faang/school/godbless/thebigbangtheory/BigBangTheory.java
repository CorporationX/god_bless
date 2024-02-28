package faang.school.godbless.thebigbangtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int NUMBEROFTREADS = 4;
    public static void main(String... args) throws InterruptedException {
        List<Task> listTask = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBEROFTREADS);
        listTask.add(new Task("Шелдлон", "подготовка теории"));
        listTask.add(new Task("Леонард", "моделирование эксперимента"));
        listTask.add(new Task("Говард", "разработка инструментов"));
        listTask.add(new Task("Раджеш", "анализ данных"));
        for (Task task: listTask) {
            executorService.submit(task);
        }
        executorService.shutdown();

        final boolean result = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if(result)
        {
            System.out.println("Все задачи были выполнены");
        }else {
            System.out.println("Не все задачи были выполнены за отведенное время");
        }

    }
}

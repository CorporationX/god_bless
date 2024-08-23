package faang.school.godbless.BJS2_24344;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> taskList = Arrays.asList(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
                );

        taskList.forEach(executorService::execute);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Все задания успешно выполнены.");
            } else {
                System.err.println("Не все задания завершены вовремя.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Процесс выполнения был прерван.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

package faang.school.godbless.Sprint_3.BJS2_12401;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> taskList = List.of(
                new Task("Шелдон ", "подготовка теории."),
                new Task("Леонард ", "моделирование эксперимента."),
                new Task("Говард ", "разработка инструментов."),
                new Task("Раджеш ", "анализ данных.")
        );
        taskList.forEach(executorService::execute);
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Прерывание при ожидании завершения задач.");
        }
        System.out.println("Все задания выполнены.");
    }
}
package faang.school.godbless.parallelismAndThread.theBigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Task> taskList = List.of(
                new Task("Егор", "Решить задачу BigBangTheory"),
                new Task("Света", "Сделать ревью"),
                new Task("Петр", "Сходить в магазин"),
                new Task("Лена", "Почитать книгу")
        );

        taskList.forEach(executorService::execute);

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи выполнены!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package faang.school.godbless.thread.bigBangTheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> taskList = List.of(
                new Task("Sheldon", "Task 1"),
                new Task("Leonard", "Task 2"),
                new Task("Penny", "Task 3"),
                new Task("Howard", "Task 4")
        );

        taskList.forEach(executorService::execute);

        executorService.shutdown();
    }
}

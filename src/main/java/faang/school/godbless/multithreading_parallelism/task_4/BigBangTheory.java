package faang.school.godbless.multithreading_parallelism.task_4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private final static int THREAD_COUNT = 4;

    public static void main(String[] args) {
        List<Task> taskList = TaskProvider.getTasks();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        taskList.forEach(executor::submit);
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Всё задачи были завершены");
    }
}

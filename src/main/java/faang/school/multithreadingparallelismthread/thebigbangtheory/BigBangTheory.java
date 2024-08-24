package faang.school.multithreadingparallelismthread.thebigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    private static final int FIXED_THREAD_POOL = 4;
    private static final int AWAIT_TERMINATION_THREADS = 1;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_THREAD_POOL);

        List<Task> tasks = List.of(new Task("Sheldon", "theory preparation"),
                new Task("Leonard ", "is an experiment simulation"),
                new Task("Howard", "is a tool developer"),
                new Task("Rajesh", "Data Analysis"));

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(AWAIT_TERMINATION_THREADS, TimeUnit.MINUTES)) {
                System.out.println(Thread.currentThread().getName() + " Задание завершено!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

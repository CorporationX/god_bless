package school.faang.sprint_3.task_48282;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int NUM_THREADS = 4;
    private static final int AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {
        Person sheldon = new Person("Sheldon");
        Person leonard = new Person("Leonard");
        Person howard = new Person("Howard");
        Person rajesh = new Person("Rajesh");

        Task task1 = new Task(sheldon, "preparation of theory");
        Task task2 = new Task(leonard, "simulation of experiment");
        Task task3 = new Task(howard, "development of tools");
        Task task4 = new Task(rajesh, "data analysis");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                System.out.println("Not all tasks are completed within the specified time period.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error message: ", e);
            executor.shutdownNow();
        }
    }
}

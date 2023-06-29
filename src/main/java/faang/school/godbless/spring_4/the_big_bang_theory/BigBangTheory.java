package faang.school.godbless.spring_4.the_big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Task> list = List.of(
                new Task("Sheldon", "theory preparation"),
                new Task("Leonard", "simulation of an experiment"),
                new Task("Govard", "development of tools"),
                new Task("Radgesh", "data analysis")
        );

        list.forEach(pool::submit);
        pool.shutdown();

        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                System.out.println("Not all tasks are completed");
            } else {
                System.out.println("All tasks are completed");
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }

    }
}

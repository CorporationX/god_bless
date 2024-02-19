package faang.school.godbless.badabingtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Sheldon", "Theory preparing"));
        executorService.execute(new Task("Leonard", "Experiment modeling"));
        executorService.execute(new Task("Howard", "Tools development"));
        executorService.execute(new Task("Rajesh", "Data analysis"));
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tasks completed");
    }
}

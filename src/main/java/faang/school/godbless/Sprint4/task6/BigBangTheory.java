package faang.school.godbless.Sprint4.task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(4);

        execute.execute(new Task("Sheldon", "preparation of the theory"));
        execute.execute(new Task("Leonard", "simulation of the experiment"));
        execute.execute(new Task("Penny", "tool development"));
        execute.execute(new Task("Howard", "data analysis"));

        execute.shutdown();
        try {
            execute.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed");
    }
}

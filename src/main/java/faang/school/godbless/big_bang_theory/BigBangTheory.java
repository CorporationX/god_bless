package faang.school.godbless.big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public final static int QUANTITY = 4;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService excecutor = Executors.newFixedThreadPool(QUANTITY);

        List<Task> tasks = List.of(
                new Task("Task 1", "Fly"),
                new Task("Task 2", "Run"),
                new Task("Task 3", "Swim"),
                new Task("Task 4", "Dance")
        );

        tasks.forEach(excecutor::submit);

        excecutor.shutdown();
        excecutor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("All tasks executed!");
    }
}

package faang.school.godbless.multithreading_parallelism.task_5;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {
                new Chore("Clean the kitchen"),
                new Chore("Vacuum the house"),
                new Chore("Laundry"),
                new Chore("Bathroom cleaning"),
                new Chore("Organize a cluttered area")
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(executor::submit);
        executor.shutdown();
    }
}

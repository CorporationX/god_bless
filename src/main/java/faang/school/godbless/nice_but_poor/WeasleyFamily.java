package faang.school.godbless.nice_but_poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Prepare dinner", "Mop the floors", "Wash the windows"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(executor::execute);
        executor.shutdown();
        try {
            while(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Tasks not finished yet...");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("=======================");
        System.out.println("All tasks are finished!");
    }
}

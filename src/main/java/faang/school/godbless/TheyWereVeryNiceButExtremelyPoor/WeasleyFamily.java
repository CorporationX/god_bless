package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"Mop floor", "Wash dishes", "Throw garbage", "Clean windows", "Cook pie", "Hang up wet clothes"};
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : CHORES) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                System.out.println("All tasks done, let's do magic!");
            } else {
                System.out.println("Timeout occurred before termination!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Chores interrupted: " + e.getMessage());
        }
    }
}

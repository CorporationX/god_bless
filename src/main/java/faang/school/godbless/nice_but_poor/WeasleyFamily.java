package faang.school.godbless.nice_but_poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final long TIMEOUT = 4000;

    public static void main(String[] args) {
        String[] chores = {"Prepare dinner", "Mop the floors", "Wash the windows"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores)
                .map(Chore::new)
                .forEach(executor::execute);

        executor.shutdown();
        long startTime = System.currentTimeMillis();
        try {
            while(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                if (System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.println("Timeout reached!");
                    executor.shutdownNow();
                } else {
                    System.out.println("Tasks not finished yet...");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======================");
        System.out.println("Executor finished working!");
    }
}

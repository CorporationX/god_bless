package faang.school.godbless.theywereverynice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIME_OUT = 10;

    public static void main(String[] args) {
        String[] chores = {"Task1", "Task2", "Task3", "Task4"};
        ExecutorService service = Executors.newCachedThreadPool();
        for (String chore : chores) {
            service.execute(new Chore(chore));
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks are done");
    }
}

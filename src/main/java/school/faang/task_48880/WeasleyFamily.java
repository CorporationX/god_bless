package school.faang.task_48880;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Sweep the floor", "Cook food", "Do the laundry"};
        ExecutorService executors = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            executors.execute(chore);
        }
        try {
            if (!executors.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Not all tasks were completed within the specified time period");
                executors.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

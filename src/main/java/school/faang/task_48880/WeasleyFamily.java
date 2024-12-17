package school.faang.task_48880;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final Logger log = LoggerFactory.getLogger(WeasleyFamily.class);

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
            log.info("Task interrupted");
        }
    }
}

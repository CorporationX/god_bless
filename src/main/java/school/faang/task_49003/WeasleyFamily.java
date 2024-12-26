package school.faang.task_49003;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Sweep the flore", "Cook dinner"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chere : chores) {
            executor.submit(new Chore(chere));
        }

        executor.shutdown();
        System.out.println("All chores have been sent for execution.");

    }
}

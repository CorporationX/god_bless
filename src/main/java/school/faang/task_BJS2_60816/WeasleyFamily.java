package school.faang.task_BJS2_60816;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    static final List<String> choresList = List.of(
            "Wash the dishes",
            "Sweep the floor",
            "Cook dinner"
    );

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String choreTitle : choresList) {
            Chore chore = new Chore(choreTitle);
            executorService.submit(chore);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("The thread was intrrupted " + e);
        }
    }
}

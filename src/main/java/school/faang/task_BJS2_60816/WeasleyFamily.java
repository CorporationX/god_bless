package school.faang.task_BJS2_60816;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        final List<String> choresList = List.of("Wash the dishes", "Sweep the floor", "Cook dinner");

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String choreTitle : choresList) {
            Chore chore = new Chore(choreTitle);
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}

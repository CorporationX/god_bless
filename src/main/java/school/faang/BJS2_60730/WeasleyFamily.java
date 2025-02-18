package school.faang.BJS2_60730;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] tasks = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void doTask() {
        for (String task : tasks) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
    }

}

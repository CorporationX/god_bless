package school.faang.routine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] chores = {"помыть посуду", "подмести пол",
            "приготовить ужин", "погладить кота", "почистить диван"};

    public void parallelTask() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
    }
}

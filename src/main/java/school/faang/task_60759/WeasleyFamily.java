package school.faang.task_60759;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] chores = new String[]{
            "помыть посуду", "подмести пол", "приготовить ужин"};

    public void pool() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }

}

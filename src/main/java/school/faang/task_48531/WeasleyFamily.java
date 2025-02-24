package school.faang.task_48531;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести полы", "приготовить ужин"};

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            threadPool.execute(chore);
        }
        threadPool.shutdown();
    }
}




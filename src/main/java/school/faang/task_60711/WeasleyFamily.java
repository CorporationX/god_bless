package school.faang.task_60711;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String choreTitle : CHORES) {
            Chore chore = new Chore(choreTitle);
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}

package school.faang.task_60808;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
    }
}
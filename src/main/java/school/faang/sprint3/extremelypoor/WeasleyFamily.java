package school.faang.sprint3.extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String task : chores) {
            executorService.execute(new Chore(task));
        }
        executorService.shutdown();
    }
}

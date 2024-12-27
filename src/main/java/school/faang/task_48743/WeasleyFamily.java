package school.faang.task_48743;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private String[] chores;

    public WeasleyFamily(String... chores) {
        this.chores = chores;
    }

    public void startChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
    }
}

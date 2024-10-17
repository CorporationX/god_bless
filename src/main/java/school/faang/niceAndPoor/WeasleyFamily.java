package school.faang.niceAndPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    ExecutorService executor = Executors.newCachedThreadPool();

    public void cleaning(String[] chores) {
        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.submit(task);
        }
        executor.shutdown();
    }
}

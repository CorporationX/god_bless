package school.faang.multithreading.theyWereVeryNiceButExtremlyPoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        this.chores.add(chore);
    }

    public void executeChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}

package school.faang.weasley.family;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        chores.add(chore);
    }

    public void executeRoutine() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(Chore chore : chores) {
            executor.submit(chore);
        }
        executor.shutdown();
    }
}

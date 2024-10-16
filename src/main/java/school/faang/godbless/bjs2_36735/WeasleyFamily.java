package school.faang.godbless.bjs2_36735;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final List<String> chores = new ArrayList<>();

    public void addChore(String chore) {
        chores.add(chore);
    }

    public void doChores() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        chores.forEach(chore -> {
            Chore runnable = new Chore(chore);
            pool.submit(runnable);
        });
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            throw new IllegalStateException("Interrupt before chores pool terminated");
        }
    }
}

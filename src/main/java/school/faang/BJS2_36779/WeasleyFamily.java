package school.faang.BJS2_36779;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class WeasleyFamily {
    private List<String> chores;

    public WeasleyFamily(List<String> chores) throws InterruptedException {
        this.chores = chores;

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}


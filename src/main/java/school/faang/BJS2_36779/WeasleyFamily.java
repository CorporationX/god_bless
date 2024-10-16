package school.faang.BJS2_36779;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class WeasleyFamily {
    private List<Chore> chores;

    public WeasleyFamily(List<Chore> chores) throws InterruptedException {
        this.chores = chores;

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("==================================");
                System.out.println("На завтра останется: ");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}


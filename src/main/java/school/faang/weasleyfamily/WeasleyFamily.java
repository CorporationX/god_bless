package school.faang.weasleyfamily;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class WeasleyFamily {

    private List<String> chores;

    public WeasleyFamily(List<String> chores) {
        Objects.requireNonNull(chores, "Chores cannot be null");
        this.chores = chores;
    }

    public void doChores() {
        List<Chore> tasks = new ArrayList<>();
        chores.forEach(chore -> tasks.add(new Chore(chore)));
        ExecutorService executor = Executors.newCachedThreadPool();
        tasks.forEach(executor::execute);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public void setChores(List<String> chores) {
        Objects.requireNonNull(chores, "Chores cannot be null");
        this.chores = chores;
    }
}

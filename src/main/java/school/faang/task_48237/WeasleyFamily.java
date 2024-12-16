package school.faang.task_48237;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final List<Chore> chores;

    public WeasleyFamily() {
        this.chores = new ArrayList<>();
    }

    public void addChore(@NonNull Chore chore) {
        chores.add(chore);
    }

    public void doAllChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(executor::execute);
        executor.shutdown();
    }

}

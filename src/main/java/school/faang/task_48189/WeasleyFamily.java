package school.faang.task_48189;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final List<String> chores = new ArrayList<>();

    public void solveChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(strChore -> {
            Chore chore = new Chore(strChore);
            executorService.execute(chore);
        });

        executorService.shutdown();
    }

    public void addChore(@NonNull String chore) {
        chores.add(chore);
    }
}

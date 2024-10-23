package school.faang.triwizard.tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return CompletableFuture.runAsync(task::performTask, executor)
                .thenApply(voidResult -> {
                    school.getTaskReward(task);
                    return school;
                })
                .whenComplete((res, e) -> executor.shutdown());
    }

    public School getChampion(List<School> schools) {
        return schools.stream()
                .max(Comparator.comparingDouble(School::getTotalPoints))
                .orElseThrow(() -> new IllegalArgumentException("Список школ пуст"));
    }
}

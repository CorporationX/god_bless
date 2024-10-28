package school.faang.turnir;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(task::runTask)
                .thenApply(result -> {
                    school.updateStudentsScores(result);
                    school.team().forEach(System.out::println);
                    return school;
                });
    }
}

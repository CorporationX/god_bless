package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureResult =
                CompletableFuture.supplyAsync(() -> {

                    return null;
                });

        return futureResult;
    }
}

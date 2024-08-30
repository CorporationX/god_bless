package faang.school.godbless.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam()
                    .stream()
                    .forEach(student -> task.task(student));
            return school;
        });
    }
}

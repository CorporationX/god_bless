package sprint5.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.students().forEach(student -> student.completeTask(task));
            return school;
        });
    }
}

package faang.school.godbless.BJS2_25023;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().
                    forEach(student -> student.setPoints(student.getPoints() + (task.reward() + task.difficulty()) * 2));

            return school;
        });
    }
}
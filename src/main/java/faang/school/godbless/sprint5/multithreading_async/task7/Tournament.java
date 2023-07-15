package faang.school.godbless.sprint5.multithreading_async.task7;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}

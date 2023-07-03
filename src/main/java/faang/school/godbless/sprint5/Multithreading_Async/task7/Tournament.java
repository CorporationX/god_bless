package faang.school.godbless.sprint5.Multithreading_Async.task7;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}

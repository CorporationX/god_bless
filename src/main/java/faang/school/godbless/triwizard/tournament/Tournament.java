package faang.school.godbless.triwizard.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            for (Student student: school.getTeam()) {
                student.setPoints(student.getPoints() + task.getReward());
            }
            return school;
        });
    }
}

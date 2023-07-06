package faang.school.godbless.triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> result = CompletableFuture.supplyAsync(() -> {
            for(Student student : school.getTeam()) {
                student.setPoints(student.getPoints() + task.getReward());
            }
            return school;
        });
        return result;
    }
}

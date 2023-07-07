package faang.school.godbless.triwizard.tournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            int i = task.getDifficulty() * task.getReward();
            for (Student student : school.getStudents()) {
                student.setPoints(i);
            }
            return new School(school.getName(), school.getStudents());
        });
    }
}

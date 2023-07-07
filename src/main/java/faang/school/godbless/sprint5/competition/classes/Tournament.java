package faang.school.godbless.sprint5.competition.classes;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return school;
        });
    }
}
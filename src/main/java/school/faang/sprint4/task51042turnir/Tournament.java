package school.faang.sprint4.task51042turnir;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * task.getDifficult());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Student student : school.getTeam()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }
}

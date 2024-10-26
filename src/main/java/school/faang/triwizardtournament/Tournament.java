package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task, ExecutorService myPool) {
        return CompletableFuture.supplyAsync(() -> {
            int addPoints = task.reward() / school.getTeam().size();
            school.getTeam().stream().forEach(student -> student.setPoints(student.getPoints() + addPoints));
            try {
                Thread.sleep(task.getJoinTime());
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка метода Tournament.startTask", e);
            }
            return school;
        }, myPool);
    }
}

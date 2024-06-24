package faang.school.godbless.future.tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executorService) {
        int randomReward = ThreadLocalRandom.current().nextInt(task.getReward());
        CompletableFuture.supplyAsync(() -> {
            school.getTeam().forEach(student -> student.setPoints(randomReward + student.getPoints()));
            return school;
        }, executorService);
        return CompletableFuture.completedFuture(school);
    }
}

package faang.school.godbless.BJS214408;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() ->
                {
                    for (Student student : school.getTeam()) {
                        student.setPoints(student.getPoints() + task.getReward());
                    }
                    return school;
                }
                , EXECUTOR_SERVICE);
    }
}

package faang.school.godbless.four;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final ExecutorService executor;

    public Tournament(int numThread) {
        if (numThread <= 0 && numThread > 100) {
            throw new IllegalArgumentException("In constructor Tournament class apply int <= 0 or int > 100");
        }
        executor = Executors.newFixedThreadPool(numThread);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> futureSchool = CompletableFuture.completedFuture(school);
        for (Student student : school.getTeam()) {
            futureSchool.thenAcceptAsync(sch -> student.getAndAddPoint(task.getReward()));
        }
        return futureSchool;
    }
}

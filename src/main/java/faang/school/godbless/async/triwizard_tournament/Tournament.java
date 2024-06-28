package faang.school.godbless.async.triwizard_tournament;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    private final int POOL_SIZE = 2;
    private final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);

    public CompletableFuture<School> startTask(School school, Task task) {

        return null;
    }

    private Student completingTask(Student student, Task task) {
        student.setPoints(student.getPoints() + task.getDifficulty() * task.getReward() / student.getYear());
        return student;
    }
}

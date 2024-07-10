package faang.school.godbless.async.triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {

    private final int DURATION_TASK = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {

        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
                    studentDoingTask(school, task);
                    return school;
                }
        );
        return future;
    }


    private void doingTask(Task task, Student student) {
        try {
            Thread.sleep(task.getDifficulty() * DURATION_TASK / student.getYear());
        } catch (InterruptedException e) {
            log.warn("%s interrupted doing task", student.getName());
            throw new RuntimeException(e);
        }
    }

    private synchronized School studentDoingTask(School school, Task task) {
        school.getStudents().stream().forEach(student ->
        {
            doingTask(task, student);
            student.setPoints(student.getPoints() + task.getReward());
            log.info(String.format("%s done task:%s and get points:%d and now him points: %d",
                    student.getName(), task.getName(),task.getReward(),student.getPoints()));
        });
        return school;
    }
}

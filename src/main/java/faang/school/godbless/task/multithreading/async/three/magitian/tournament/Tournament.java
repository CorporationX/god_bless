package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final ExecutorService executor;

    public Tournament(int threadPoolSize) {
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> doTask(school, task), executor);
    }

    private School doTask(School school, Task task) {
        log.info("{} do task: {}, reward: {}", school.getName(), task.getName(), task.getReward());
        sleep(task.getDifficulty());
        updatePoints(school.getTeam(), task.getReward());
        return school;
    }

    private void updatePoints(List<Student> students, long reward) {
        students.forEach(student -> student.addPoint(reward));
    }

    private void sleep(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}

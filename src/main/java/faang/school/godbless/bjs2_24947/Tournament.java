package faang.school.godbless.bjs2_24947;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
public class Tournament {
    private final ExecutorService schoolsExecutorService;

    public Tournament(int numberOfSchools) {
        this.schoolsExecutorService = Executors.newFixedThreadPool(numberOfSchools);
    }

    public void finish() {
        shutdownAndAwait(schoolsExecutorService);
    }

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
                    sleepThread(1000L * task.getDifficulty());
                    return solveTask(school, task);
                },
                schoolsExecutorService);
    }

    private School solveTask(School school, Task task) {
        int reward = task.getReward();
        List<Student> students = school.getTeam();

        ExecutorService studentsExecutorService = Executors.newFixedThreadPool(students.size());
        students.forEach(student -> studentsExecutorService.execute(
                () -> student.addPoints(reward)
        ));

        shutdownAndAwait(studentsExecutorService);

        return school;
    }

    private School solveTaskSecondApproach(School school, Task task) {
        int reward = task.getReward();
        List<Student> students = school.getTeam();

        ExecutorService studentsExecutorService = Executors.newFixedThreadPool(students.size());
        List<CompletableFuture<Void>> futures = students.stream()
                .map(student -> CompletableFuture.runAsync(
                        () -> student.addPoints(reward), studentsExecutorService))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        return school;
    }

    private void sleepThread(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }

    private void shutdownAndAwait(ExecutorService executorService) {
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}

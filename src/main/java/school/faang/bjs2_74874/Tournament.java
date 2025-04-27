package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Tournament {
    private static final long EXECUTION_TIME = 1000L;
    private static final int NUM_THREADS = 2;
    private static final int MAX_EXPECTATION = 60;

    private final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);


    public CompletableFuture<School> startTask(School school, Task task) {
        if (school == null || task == null) {
            throw new ParamInTournamentIsNullException();
        }
        return CompletableFuture.supplyAsync(() -> taskCompletion(school, task), pool);
    }

    private School taskCompletion(School school, Task task) {
        try {
            log.info("School {} start task {}", school.name(), task.name());
            Thread.sleep(EXECUTION_TIME * task.reward());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        calculatePoints(school, task);
        return school;
    }

    private void calculatePoints(School school, Task task) {
        int numStudents = school.students().size();
        if (numStudents == 0) {
            throw new SchoolIsEmptyException();
        }

        int pointsForStudent = task.reward() / numStudents;

        school.students().stream()
                .skip(1)
                .forEach(student -> student.setPoints(student.getPoints() + pointsForStudent));

        school.students().stream()
                .limit(1)
                .forEach(student -> student.setPoints(student.getPoints() + pointsForStudent
                        + task.reward() % numStudents));
    }

    public void poolShutdown() {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Thread stoppage error");
            pool.shutdownNow();
        }
    }
}

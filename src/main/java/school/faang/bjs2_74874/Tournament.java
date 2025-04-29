package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if (school.students().isEmpty()) {
            throw new SchoolIsEmptyException();
        }
        return CompletableFuture.supplyAsync(() -> taskCompletion(school, task), pool);
    }

    private School taskCompletion(School school, Task task) {
        try {
            log.info("School {} start task {}", school.name(), task.name());
            Thread.sleep(EXECUTION_TIME * task.difficulty());
        } catch (InterruptedException ex) {
            throw new ThreadStoppedException(ex);
        }
        calculatePoints(school, task);
        return school;
    }

    private void calculatePoints(School school, Task task) {
        Queue<Integer> pointsDistribution = calculatePointsDistribution(school, task);

        school.students().forEach(student ->
                student.setPoints(student.getPoints() +
                        Objects.requireNonNull(pointsDistribution.poll())));
    }

    private Queue<Integer> calculatePointsDistribution(School school, Task task) {
        int numStudents = school.students().size();
        int pointsForStudent = task.reward() / numStudents;
        int remainder = task.reward() % numStudents;

        return IntStream.range(0, numStudents)
                .map(i -> Objects.equals(i, 0) ? pointsForStudent + remainder : pointsForStudent)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
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

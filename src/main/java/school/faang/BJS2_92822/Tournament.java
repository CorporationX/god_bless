package school.faang.BJS2_92822;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Tournament {
    private static final int DEFAULT_TIME_SLEEP = 1000;

    public CompletableFuture<School> startTask(School school, List<Task> tasks) {
        ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
        List<CompletableFuture<Void>> taskFutures = tasks.stream()
                .map(task ->
                        CompletableFuture.runAsync(new Runnable() {
                            @Override
                            public void run() {
                                Student student = distributeAmongTasks(school.getTeam(), school);
                                performTask(student, task);
                            }
                        }, executor))
                .toList();

        CompletableFuture<School> future = CompletableFuture.allOf(
                        taskFutures.toArray(new CompletableFuture[0]))
                .thenApply(v -> school);
        executor.shutdown();

        return future;
    }

    private Student distributeAmongTasks(List<Student> students, School school) {
        synchronized (school) {
            Student student = students.stream()
                    .filter(st -> Objects.equals(st.getIsBusy().get(), false))
                    .findFirst()
                    .orElseThrow();
            AtomicBoolean isBusy = new AtomicBoolean(true);
            student.setIsBusy(isBusy);
            return student;
        }
    }

    private void performTask(Student student, Task task) {
        int point = task.getReward();
        int difficulty = task.getDifficulty();
        sleepThread(DEFAULT_TIME_SLEEP * difficulty);
        student.setPoints((student.getPoints() + point));
        log.info("Cтудент {} школы имеет очков - {}",
                student.getName(), student.getPoints());

        AtomicBoolean isBusy = new AtomicBoolean(false);
        student.setIsBusy(isBusy);
    }

    private void sleepThread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

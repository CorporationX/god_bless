package school.faang.BJS2_92822;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@Slf4j
public class Tournament {
    private static final int DEFAULT_TIME_SLEEP = 1000;

    public CompletableFuture<School> startTask(School school, List<Task> tasks) {
        ExecutorService executor = school.getExecutor();
        List<CompletableFuture<Void>> taskFutures = tasks.stream()
                .map(task ->
                        CompletableFuture.runAsync(() -> {
                            Student student = distributeAmongTasks(school.getTeam());
                            performTask(student, task);
                        }, executor))
                .collect(Collectors.toList());

        CompletableFuture<School> future = CompletableFuture.allOf(
                        taskFutures.toArray(new CompletableFuture[0]))
                .thenApply(v -> school);
        executor.shutdown();
        return future;
    }

    private synchronized Student distributeAmongTasks(List<Student> students) {
        Optional<Student> student = students.stream()
                .filter(st -> !st.isBusy())
                .reduce((st2, st1) -> st1);

        if (student.isPresent()) {
            student.get().setBusy(true);
        } else {
            throw new NullPointerException();
        }

        return student.get();
    }

    private void performTask(Student student, Task task) {
        int point = task.getReward();
        int difficulty = task.getDifficulty();
        sleepThread(DEFAULT_TIME_SLEEP * difficulty);
        student.setPoints((student.getPoints() + point));
        log.info("Cтудент {} школы имеет очков - {}",
                student.getName(), student.getPoints());
        student.setBusy(false);
    }

    private void sleepThread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package tournament;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@RequiredArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void startTaskForAllStudents(@NonNull Task task) {
        if (team.isEmpty()) {
            throw new NoSuchElementException("School team is empty!");
        }
        try (ExecutorService executor = Executors.newFixedThreadPool(team.size())) {
            startTasks(executor, task);
            waitForFinishAllTasks(executor);
        }
    }

    private void startTasks(@NonNull ExecutorService executor, @NonNull Task task) {
        team.forEach(student -> executor.execute(() -> {
            student.addPoints(task.getFinalReward());
            try {
                Thread.sleep(Task.TIME_TO_COMPLETE * task.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }));
    }

    private void waitForFinishAllTasks(@NonNull ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info(String.format("All students of %s finished theirs tasks", name));
            } else {
                log.error("Time out!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

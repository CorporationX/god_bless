package three.mags;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private final ExecutorService executor;

    public CompletableFuture<School> startTask(School school, Task task) {
        if (Objects.isNull(school) || Objects.isNull(task)) {
            log.error("School or task is null!");
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
        return CompletableFuture.supplyAsync(() -> runTaskWithSchedule(school, task), executor);
    }

    private synchronized School runTaskWithSchedule(School school, Task task) {
        try {
            Thread.sleep(task.getDifficulty());
            return setPointsForStudents(school, task);
        } catch (InterruptedException e) {
            log.error("Thread is interrupted!");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private School setPointsForStudents(School school, Task task) {
        int pointsPerStudent = task.getReward() / school.getStudents().size();
        return modifyStudentsPoints(school, pointsPerStudent);
    }

    private School modifyStudentsPoints(School school, int aditionalPoints) {
        school.getStudents()
                .stream()
                .forEach(student -> student.setPoints(student.getPoints() + aditionalPoints));
        return school;
    }
}

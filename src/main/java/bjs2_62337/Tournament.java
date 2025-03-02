package bjs2_62337;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public static final int WORK_TIME_FACTOR = 2;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) WORK_TIME_FACTOR * task.difficulty());

                if (school.team().isEmpty()) {
                    return school;
                }

                var pointsPerStudent = task.reward() / school.team().size();
                var pointsToLastStudent = pointsPerStudent + task.reward() % school.team().size();

                if (pointsPerStudent == pointsToLastStudent) {
                    school.team().forEach(student -> student.addPoints(pointsPerStudent));
                } else {
                    school.team()
                            .stream()
                            .limit(school.team().size() - 1)
                            .forEach(student -> student.addPoints(pointsPerStudent));
                    school.team().get(school.team().size() - 1).addPoints(pointsToLastStudent);
                }
            } catch (InterruptedException e) {
                log.error("Ошибка в методе startTask: {}", e.getMessage(), e);
            }

            return school;
        });
    }
}

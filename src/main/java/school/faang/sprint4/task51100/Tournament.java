package school.faang.sprint4.task51100;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint4.task51100.model.School;
import school.faang.sprint4.task51100.model.Student;
import school.faang.sprint4.task51100.model.Task;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("School {} starts work on task {}", school.getName(), task.getName());
        return CompletableFuture.supplyAsync(() -> {
            int reward = processTask(task);
            for (Student student : school.getTeam()) {
                student.addPoint(reward);
            }
            log.info("School {} finishes work on task {}", school.getName(), task.getName());
            return school;
        });
    }

    private int processTask(Task task) {
        try {
            Thread.sleep(task.getDifficulty() * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return task.getReward();
    }

    public static School getSchoolWinner(List<School> schools) {
        return schools.stream()
                .max(Comparator.comparing(School::getTotalPoints))
                .orElse(null);
    }


}

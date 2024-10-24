package school.faang.Multithreading.sprint_4.WizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> schoolFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L * task.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Операция была прервана", e);
                throw new RuntimeException(e);
            }

            for (Student student : school.getStudents()) {
                student.addPoints(task.getReward());
            }
            return school;
        });

        return schoolFuture;
    }
}

package school.faang.async.triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("{} started task {}", school.name(), task.name());
            try {
                Thread.sleep(task.difficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int studentReward = task.reward() / school.team().size();
            school.team().forEach(student -> {
                log.info("Student {} from {} school was awarded {} points for completing task {}",
                        student.getName(), school.name(), studentReward, task.name());
                student.addPoints(studentReward);
            });
            log.info("{} finished task {}", school.name(), task.name());
            return school;
        });
    }

}

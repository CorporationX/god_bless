package school.faang.bjs2_82810;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficult() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread was interrupted");
            }
            for (Student student : school.getStudentList()) {
                student.addPoints(task.getReward());
            }
            return school;
        });
    }
}

package school.faang.BJS2_62426;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(task.getDifficulty() * 100L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("Школа {} выполнила задание {}, каждый студент получил по {} очков!",
                            school.getName(), task.getName(), task.getReward());
                    return school;
                })
                .thenApply(result -> {
                    school.getTeam()
                            .forEach(stud -> stud.setPoints(stud.getPoints() + task.getReward()));
                    school.getTotalPoints();
                    return school;
                });
    }
}

package school.faang.bjs51023;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public static final long QUEST_TIME = 1000;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(QUEST_TIME * task.difficulty());
                    } catch (InterruptedException e) {
                        return 0;
                    }
                    log.info("School {} finished task {}", school.getName(), task.name());
                    return task.reward();
                }).thenApply((reward) -> {
                    school.getTeam().forEach((player) -> player.increasePoints(reward));
                    return school;
                });
    }
}

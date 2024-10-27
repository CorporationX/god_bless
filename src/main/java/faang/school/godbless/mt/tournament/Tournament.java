package faang.school.godbless.mt.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private final long TIME_FOR_DIFFICULT = 1000;
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(()-> {
            log.info("School '{}' start task '{}'. Difficulty = '{}'", school.getName(), task.getName(), task.getDifficulty());
           try {
               Thread.sleep(task.getDifficulty() * TIME_FOR_DIFFICULT);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           school.getStudents().forEach(s-> s.increasePoints(task.getReward()));
            log.info("School '{}' finished task '{}'. Score for task = '{}'", school.getName(), task.getName(), task.getReward());
           return school;
        });
    }
}

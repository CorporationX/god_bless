package faang.school.godbless.mt.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    private final static int THREAD_COUNT = 10;
    private final static long TIME_FOR_DIFFICULT = 1000;

    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

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
        }, executor);
    }

    public void endTournament() {
        executor.shutdown();
    }
}

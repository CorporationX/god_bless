package school.faang.multithreading.async.bjs2_74925.triwizard_tournamrnt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class Tournament {
    private static final int ONE_SECOND_IN_MS = 1000;
    private final ExecutorService pool;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(
                () -> processTask(school, task), pool);
    }

    private School processTask(School school, Task task) {
        try {
            Thread.sleep(ONE_SECOND_IN_MS * task.getDifficulty());
        } catch (InterruptedException e) {
            log.error("Error during sleep = {}", e.getMessage());
            throw new RuntimeException(e);
        }
        List<Student> team = school.getTeam();
        int randIndex = new Random().nextInt(team.size());
        Student student = team.get(randIndex);
        student.addPoints(task.getReward());
        log.info("Student = {}", student);
        log.info("School = {}", school);
        return school;
    }
}

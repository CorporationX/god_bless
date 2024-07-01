package faang.school.godbless.tournament_of_three;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Tournament {
    private final int COMPLETION_TIME_LOWER_BOUND = 1000;
    private final int COMPLETION_TIME_UPPER_BOUND = 4001;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info(school.name() + " started executing " + task.getName());

            List<Student> studentList = school.studentList();
            int rewardPoints = task.getTotalReward();

            int completionTime = ThreadLocalRandom.current().nextInt(
                    COMPLETION_TIME_LOWER_BOUND,
                    COMPLETION_TIME_UPPER_BOUND);

            try {
                Thread.sleep(completionTime);
            } catch (InterruptedException e) {
                throw new RuntimeException("Cannot continue executing task due to interruption " + e.getMessage());
            }

            studentList.forEach(student -> student.setPoints(student.getPoints() + rewardPoints));
            log.info(school.name() + " ended task in " + completionTime);

            return new School(school.name(), studentList);
        });
    }
}

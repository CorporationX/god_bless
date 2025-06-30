package school.faang.bjs2_82817;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final long SLEEP_TIME = 2000L;

    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("школа {} начинает квест {} со сложностью {} и наградой {}", school.getName(), task.getName(),
                task.getDifficulty(), task.getReward());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * SLEEP_TIME);
            } catch (InterruptedException e) {
                log.info("поток прерван во время выполнения квеста");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            int rewardStudent = task.getReward() / school.getTeam().size();
            school.getTeam().forEach(student -> {
                student.addPoints(rewardStudent);
                log.info("студент {} получил {} очков после выполнения квеста {}", student.getName(), task.getReward(),
                        task.getName());
            });


            log.info("школа {} завершила квест {}\n    общее количество очков: {}", school.getName(), task.getName(),
                    school.getTotalPoints());
            return school;
        });
    }
}

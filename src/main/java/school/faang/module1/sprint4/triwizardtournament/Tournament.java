package school.faang.module1.sprint4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        if (isWin()) {
            try {
                Thread.sleep(task.difficulty());
            } catch (InterruptedException e) {
                log.debug("Поток был прерван при выполнении задания", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            return CompletableFuture.supplyAsync(() -> {
                for (Student student : school.team()) {
                    student.addPoints(task.reward());
                }
                return school;
            });
        } else {
            return CompletableFuture.supplyAsync(() -> school);
        }

    }

    private boolean isWin() {
        return (int) (Math.random() * 10) <= 7;
    }
}
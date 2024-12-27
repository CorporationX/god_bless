package school.faang.sprint4.bjs_50995;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static final int MS = 1000;
    private static final String MESSAGE_OF_THREAD_INTERRUPTED = "Поток был прерван!";

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Команда {} начала выполнять задание {}", school.getName(), task.name());

            try {
                Thread.sleep((long) task.difficulty() * MS);
            } catch (InterruptedException e) {
                log.info(MESSAGE_OF_THREAD_INTERRUPTED);
                Thread.currentThread().interrupt();
            }

            findTotalPoints(school, task.reward());

            log.info("Команда {} выполнила задание {}.\nОбщее количество очков - {}",
                    school.getName(), task.name(), school.getTotalPoints());

            return school;
        });
    }

    private void findTotalPoints(School school, int reward) {
        int totalPoints = 0;

        for (Student student : school.getTeam()) {
            student.addPoints(reward);
            totalPoints += student.getPoints();
        }

        school.setTotalPoints(totalPoints);
    }
}

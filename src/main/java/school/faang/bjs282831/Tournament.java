package school.faang.bjs282831;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("🏰 Школа {} начинает выполнение задания '{}'",
                        school.getName(), task.getName());

                int executionTime = task.getDifficulty() * 100;
                Thread.sleep(executionTime);

                boolean success = simulateTaskExecution(task.getDifficulty());

                if (success) {
                    school.distributeReward(task.getReward());

                    log.info("✨ Школа {} успешно выполнила задание '{}' и получила {} очков!",
                            school.getName(), task.getName(), task.getReward());

                    school.getTeam().forEach(student ->
                            log.info("   👨‍🎓 {} ({} год) - {} очков",
                                    student.getName(), student.getYear(), student.getPoints()));
                } else {
                    log.warn("❌ Школа {} не смогла выполнить задание '{}'",
                            school.getName(), task.getName());
                }

                return school;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("⚡ Выполнение задания '{}' для школы {} было прервано",
                        task.getName(), school.getName(), e);
                return school;
            }


        });
    }

    private boolean simulateTaskExecution(int difficulty) {
        int successChance = Math.max(30, 100 - difficulty * 5);
        return ThreadLocalRandom.current().nextInt(100) < successChance;
    }

    public School determineWinner(List<School> schools) {
        return schools.stream()
                .max((school1, school2) ->
                        Integer.compare(school1.getTotalPoints(), school2.getTotalPoints()))
                .orElse(null);
    }

    public void displayResults(List<School> schools) {
        log.info("🏆 === РЕЗУЛЬТАТЫ ТУРНИРА === 🏆");

        schools.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getTotalPoints(), s1.getTotalPoints()))
                .forEach(school -> {
                    log.info("🏫 {} - {} очков", school.getName(), school.getTotalPoints());
                    school.getTeam().forEach(student ->
                            log.info("   👨‍🎓 {} - {} очков", student.getName(), student.getPoints()));
                });

        School winner = determineWinner(schools);
        if (winner != null) {
            log.info("🎉 ПОБЕДИТЕЛЬ ТУРНИРА: {} с {} очками! 🎉",
                    winner.getName(), winner.getTotalPoints());
        }
    }
}

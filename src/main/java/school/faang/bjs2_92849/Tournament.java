package school.faang.bjs2_92849;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Tournament {
    private static final int THREAD_SLEEP_MS = 1000;

    public CompletableFuture<School> startTask(School school, Task task, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = task.getDifficulty() * THREAD_SLEEP_MS;
                Thread.sleep(delay);

                school.getTeam().forEach(student ->
                        student.addPoints(task.getReward()));

                return school;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Задание было прервано для школы {}: {}", school.getName(), e.getMessage());
                return school;
            }
        }, executor);
    }

    public CompletableFuture<Void> runTournament(List<CompletableFuture<School>> schoolTasks,
                                                 ExecutorService executor) {
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                schoolTasks.toArray(new CompletableFuture[0])
        );

        return allTasks.thenApplyAsync(v -> {
            List<School> results = schoolTasks.stream()
                    .map(CompletableFuture::join)
                    .toList();

            results.forEach(school ->
                    log.info("{}: {} очков", school.getName(), school.getTotalPoints())
            );

            return determineWinner(results);
        }, executor).thenAcceptAsync(winnerMessage -> {
            log.info(winnerMessage);
        }, executor).exceptionally(throwable -> {
            log.error("Ошибка во время турнира: {}", throwable.getMessage());
            return null;
        });
    }

    private String determineWinner(List<School> schools) {
        if (schools.size() < 2) {
            return "Недостаточно школ для определения победителя!";
        }

        School school1 = schools.get(0);
        School school2 = schools.get(1);

        int points1 = school1.getTotalPoints();
        int points2 = school2.getTotalPoints();

        if (points1 > points2) {
            return school1.getName() + " победили в турнире!";
        } else if (points2 > points1) {
            return school2.getName() + " победили в турнире!";
        } else {
            return "Ничья! Обе школы показали одинаковый результат!";
        }
    }
}

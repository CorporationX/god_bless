package school.faang.module1.sprint4.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task firstTask = new Task("Triwizard Tournament", 10, 100);
        Task secondTask = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, firstTask);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, secondTask);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            try {
                if (hogwartsTask.get().getTotalPoints() > beauxbatonsTask.get().getTotalPoints()) {
                    log.info("Школа Хогвартс одержала победу и набрала {} очков", hogwartsTask.get().getTotalPoints());
                } else if (hogwartsTask.get().getTotalPoints() < beauxbatonsTask.get().getTotalPoints()) {
                    log.info("Школа Шармбатон одержала победу и набрала {} очков",
                            beauxbatonsTask.get().getTotalPoints());
                } else {
                    log.info("Школы разделили победу");
                }
            } catch (ExecutionException | InterruptedException e) {
                log.debug("Ошибка при получении результата выполнения задания", e);
                throw new RuntimeException("Ошибка при получении результата выполнения задания", e);
            }
        });

    }
}
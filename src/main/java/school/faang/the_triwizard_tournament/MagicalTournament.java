package school.faang.the_triwizard_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Проект: god_bless
 * Класс MagicalTournament
 * Автор: Vital
 */

@Slf4j
public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0)
        );

        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            School winner = Stream.of(hogwarts, beauxbatons)
                    .max(Comparator.comparingInt(School::getTotalPoints))
                    .orElseThrow();

            log.info("🏆 Победитель турнира: {} с {} очками!", winner.getName(), winner.getTotalPoints());

            List.of(hogwarts, beauxbatons).forEach(school -> {
                log.info("Команда {}: {} очков", school.getName(), school.getTotalPoints());
                school.getTeam().forEach(student ->
                        log.info("- {}: {} очков", student.getName(), student.getPoints()));
            });
        }).join();
    }
}
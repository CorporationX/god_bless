package school.faang.tournament.of.three.wizards;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static school.faang.tournament.of.three.wizards.Tournament.determineWinner;

@Slf4j
public class MagicalTournament {
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) {
        try (Tournament tournament = new Tournament(Executors.newFixedThreadPool(COUNT_THREAD))) {

            List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
            List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
            School hogwarts = new School("Hogwarts", hogwartsTeam);
            School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
            List<School> schools = List.of(hogwarts, beauxbatons);

            Task task1 = new Task("Triwizard Tournament", 10, 100);
            Task task2 = new Task("Yule Ball Preparations", 5, 50);

            CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
            CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

            CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                    .thenRun(() -> {
                        School winner = determineWinner(schools);
                        log.info("{} wins the tournament!", winner.getName());
                    });
            allTasks.join();

        } catch (Exception e) {
            log.error("Tournament failed unexpectedly", e);
            System.exit(1);
        }
    }
}

package school.faang.bjs2_82789;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(
                new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task triwizardTournament = new Task("Triwizard Tournament", 10, 100);
        Task yuleBallPreparations = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, triwizardTournament);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, yuleBallPreparations);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            String winner = hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()
                    ? hogwarts.getName() : beauxbatons.getName();
            log.info("{} wins the tournament!", winner);
        });
    }
}
